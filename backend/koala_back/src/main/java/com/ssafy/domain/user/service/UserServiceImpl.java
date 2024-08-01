package com.ssafy.domain.user.service;

import com.ssafy.domain.chat.service.CacheService;
import com.ssafy.domain.user.model.dto.request.UserSignUpRequest;
import com.ssafy.domain.user.model.dto.request.UserUpdateRequest;
import com.ssafy.domain.user.model.dto.response.UserFindResponse;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.domain.user.model.entity.Auth;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.domain.user.repository.AuthRepository;
import com.ssafy.domain.user.repository.UserRepository;
import com.ssafy.global.auth.jwt.JwtTokenProvider;
import com.ssafy.global.auth.jwt.dto.JwtToken;
import com.ssafy.global.common.UserInfoProvider;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final AuthRepository authRepository;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final JwtTokenProvider jwtTokenProvider;
	private final PasswordEncoder passwordEncoder;
	private final UserInfoProvider userInfoProvider;
    private final CacheService cacheService;

    @Transactional
    public UserResponse signUp(UserSignUpRequest userSignUpRequest) {
        if (userRepository.existsByLoginId(userSignUpRequest.getLoginId())) {
            throw new IllegalArgumentException("이미 사용 중인 사용자 아이디입니다.");
        }
        String encodedPassword = passwordEncoder.encode(userSignUpRequest.getPassword());
        Auth auth = authRepository.findByAuthName("user");
        System.out.println(auth.getAuthId());
        return UserResponse.toDto(userRepository.save(userSignUpRequest.toEntity(encodedPassword, auth)));
    }

    @Transactional
    @Override
    public JwtToken signIn(String loginId, String password) {
        // loginId + password 를 기반으로 Authentication 객체 생성
        // 이때 authentication은 인증 여부를 확인하는 authenticated 값이 false (생성될때는 인증 X)
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginId, password);
        System.out.println(authenticationToken);
        // 실제 검증. authenticate() 메서드를 통해 요청된 User 에 대한 검증 진행
        // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드 실행
        // UsernamePasswordAuthenticationToken의 loginId와 password를 이용해 조회된 사용자 정보가 일치하는지 확인
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        System.out.println(authentication);
        /*
        authenticate 메서드는 UsernamePasswordAuthenticationToken의 loginId와 password가 UserDetails 객체의 정보와 일치하는지 확인
        AuthenticationProvider는 Authentication 객체의 사용자명 (loginId)을 사용하여 사용자 정보를 로드합니다.
        이를 위해 UserDetailsService를 호출하며, 이때 CustomUserDetailsService의 loadUserByUsername 메서드가 실행됩니다.
         */

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

    @Transactional
    @Override
    public UserFindResponse findUser() {
        String currentLoginId = userInfoProvider.getCurrentLoginId();
        if (currentLoginId == null) {
            throw new IllegalStateException("Current login_ID is null. User might not be authenticated.");
        }

        Optional<User> optionalUser = userRepository.findByLoginId(currentLoginId);
        if (!optionalUser.isPresent()) {
            throw new NoSuchElementException("User not found with login_ID: " + currentLoginId);
        }

        User user = optionalUser.get();
        return UserFindResponse.toDto(user);
    }

    @Transactional
    @Override
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest) {

        User user = userInfoProvider.getCurrentUser();

        String encodedPassword = passwordEncoder.encode(userUpdateRequest.getPassword());
        user.setNickname(userUpdateRequest.getNickname());
        user.setPassword(encodedPassword);
        return UserResponse.toDto(userRepository.save(user));
    }

    @Transactional
    @Override
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
    public JwtToken createNewToken(String bearerToken) {
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
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(loginId, encodedPassword, authorities);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, encodedPassword, authorities);
            System.out.println("refresh : " + authentication);
            return jwtTokenProvider.generateNewToken(authentication, refreshToken);
        }
        return null;
    }

    @Override
    public void logout() {
        cacheService.clearChatHistory(userInfoProvider.getCurrentLoginId());
        SecurityContextHolder.clearContext();
    }

}

/*
[사용자 입력]
    ↓
[UsernamePasswordAuthenticationToken 생성]
    ↓
[AuthenticationManager.authenticate() 호출]
    ↓
[CustomUserDetailsService.loadUserByUsername() 호출]
    ↓
[사용자 정보 검증]
    ↓
[인증 성공 - Authentication 객체 반환]
    ↓
[JwtTokenProvider.generateToken() 호출]
    ↓
[JWT 토큰 생성 및 반환]

 */
