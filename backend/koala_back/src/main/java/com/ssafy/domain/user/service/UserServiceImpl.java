package com.ssafy.domain.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.domain.chat.service.CacheService;
import com.ssafy.domain.user.model.dto.request.UserSignUpRequest;
import com.ssafy.domain.user.model.dto.request.UserUpdateRequest;
import com.ssafy.domain.user.model.dto.response.RankingResponse;
import com.ssafy.domain.user.model.dto.response.RankingWithMyRankResponse;
import com.ssafy.domain.user.model.dto.response.UserFindResponse;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.domain.user.model.entity.Auth;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.domain.user.repository.AuthRepository;
import com.ssafy.domain.user.repository.RankingRepository;
import com.ssafy.domain.user.repository.UserRepository;
import com.ssafy.global.auth.jwt.JwtTokenProvider;
import com.ssafy.global.auth.jwt.dto.JwtToken;
import com.ssafy.global.common.UserInfoProvider;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private final UserInfoProvider userInfoProvider;
	private final JwtTokenProvider jwtTokenProvider;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final AuthRepository authRepository;
	private final RankingRepository rankingRepository;
	private final CacheService cacheService;

	@Transactional
	public UserFindResponse signUp(UserSignUpRequest userSignUpRequest) {
		if (userRepository.existsByLoginId(userSignUpRequest.getLoginId())) {
			throw new IllegalArgumentException("이미 사용 중인 사용자 아이디입니다.");
		}
		String encodedPassword = passwordEncoder.encode(userSignUpRequest.getPassword());
		Auth auth = authRepository.findByAuthName("user");
		return UserFindResponse.toDto(userRepository.save(userSignUpRequest.toEntity(encodedPassword, auth)));
	}

	@Transactional
	@Override
	public JwtToken signIn(String loginId, String password) {
		// loginId + password 를 기반으로 Authentication 객체 생성
		// 이때 authentication은 인증 여부를 확인하는 authenticated 값이 false (생성될때는 인증 X)
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginId,
			password);
		// 실제 검증. authenticate() 메서드를 통해 요청된 User 에 대한 검증 진행
		// authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드 실행
		// UsernamePasswordAuthenticationToken의 loginId와 password를 이용해 조회된 사용자 정보가 일치하는지 확인
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		// 인증 정보를 기반으로 JWT 토큰 생성
		JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);
		return jwtToken;
	}

	@Override
	public boolean checkLoginId(String loginId) {
		return userRepository.existsByLoginId(loginId);
	}

	@Override
	public boolean checkNickname(String nickname) {
		return userRepository.existsByNickname(nickname);
	}

	@Override
	@Transactional
	public UserResponse getUser() {
		String currentLoginId = userInfoProvider.getCurrentLoginId();
		if (currentLoginId == null) {
			throw new IllegalStateException("Current login_ID is null. User might not be authenticated.");
		}

		Optional<User> user = userRepository.findByLoginId(currentLoginId);
		if (!user.isPresent()) {
			throw new NoSuchElementException("User not found with login_ID: " + currentLoginId);
		}

		return UserResponse.toDto(user.get());
	}

	@Override
	@Transactional
	public UserResponse updateUser(UserUpdateRequest userUpdateRequest) {
		User user = userInfoProvider.getCurrentUser();

		String encodedPassword = passwordEncoder.encode(userUpdateRequest.getPassword());
		user.setNickname(userUpdateRequest.getNickname());
		user.setPassword(encodedPassword);
		return UserResponse.toDto(userRepository.save(user));
	}

	@Override
	@Transactional
	public void deleteUser() {
		User user = userInfoProvider.getCurrentUser();
		userRepository.delete(user);
	}

	@Override
	@Transactional
	public void increaseUserExp() {
		User user = userInfoProvider.getCurrentUser();
		user.increaseUserExp();
		if (user.getUserExp() >= 100) {
			increaseUserLevel();
			user.setUserExp(100L - user.getUserExp());
		}
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void increaseUserLevel() {
		User user = userInfoProvider.getCurrentUser();
		user.increaseUserLevel();
		userRepository.save(user);
	}

	@Override
	public JwtToken makeNewToken(String bearerToken) {
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			String refreshToken = bearerToken.substring(7);
			if (!jwtTokenProvider.validateToken(refreshToken)) {
				throw new IllegalArgumentException("Invalid refresh token");
			}
			Claims claims = jwtTokenProvider.parseClaims(refreshToken);
			String loginId = claims.get("sub").toString();
			Optional<User> userOptional = userRepository.findByLoginId(loginId);
			if (!userOptional.isPresent()) {
				throw new UsernameNotFoundException("User not found with loginId: " + loginId);
			}
			// 이미 사용자 정보를 가지고 있고, 이를 통해 직접 인증 객체를 생성
			String encodedPassword = userOptional.get().getPassword();
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_user"));
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(loginId, encodedPassword,
				authorities);
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, encodedPassword,
				authorities);
			return jwtTokenProvider.generateNewToken(authentication, refreshToken);
		}
		return null;
	}

	@Override
	public void logout() {
		cacheService.clearChatHistory(userInfoProvider.getCurrentLoginId());
		SecurityContextHolder.clearContext();
	}

	@Override
	public RankingWithMyRankResponse getRanking() {
		Long userId = userInfoProvider.getCurrentUserId();
		Integer myRank = rankingRepository.findByUserId(userId).getRanking();
		List<RankingResponse> rankings = new ArrayList<>();
		rankingRepository.findTop10ByOrderByRanking().forEach(ranking -> rankings.add(RankingResponse.toDto(ranking)));
		return RankingWithMyRankResponse.toDto(rankings, myRank);
	}
}
