package com.ssafy.domain.user.service;

import com.ssafy.domain.user.model.dto.request.SignUpRequest;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.domain.user.model.entity.Auth;
import com.ssafy.domain.user.repository.AuthRepository;
import com.ssafy.domain.user.repository.UserRepository;
import com.ssafy.global.auth.jwt.JwtTokenProvider;
import com.ssafy.global.auth.jwt.dto.JwtToken;
import com.ssafy.global.error.exception.TokenException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthRepository authRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    @Transactional
    public UserResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByLoginId(signUpRequest.getLoginId())) {
            throw new IllegalArgumentException("이미 사용 중인 사용자 아이디입니다.");
        }
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        Auth auth = authRepository.findByAuthName("user");
        System.out.println(auth.getAuthId());
        return UserResponse.toDto(userRepository.save(signUpRequest.toEntity(encodedPassword, auth)));
    }


    @Transactional
    @Override
    public JwtToken signIn(String loginId, String password) {
        // loginId + password 를 기반으로 Authentication 객체 생성
        // 이때 authentication은 인증 여부를 확인하는 authenticated 값이 false (생성될때는 인증 X)
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginId, password);

        // 실제 검증. authenticate() 메서드를 통해 요청된 User 에 대한 검증 진행
        // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드 실행
        // UsernamePasswordAuthenticationToken의 loginId와 password를 이용해 조회된 사용자 정보가 일치하는지 확인
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 인증 정보를 기반으로 JWT 토큰 생성
        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);
        return jwtToken;
    }

    public JwtToken generateNewAccessToken(String refreshToken) {
        if (!jwtTokenProvider.validateRefreshToken(refreshToken)) {
            throw new TokenException("Invalid Refresh Token");
        }
        String loginId = jwtTokenProvider.getAuthentication(refreshToken).getName();
        String newAccessToken = jwtTokenProvider.generateAccessToken(loginId);
        return JwtToken.builder()
                .grantType("Bearer")
                .accessToken(newAccessToken)
                .refreshToken(refreshToken) // 기존 Refresh Token은 기대로 사용합니다
                .build();
    }

    @Override
    public boolean checkLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }

    @Override
    public boolean checkNickname(String nickname) {
        return userRepository.existsByNickname(nickname);
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