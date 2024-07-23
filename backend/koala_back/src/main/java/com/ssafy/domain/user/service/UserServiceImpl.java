package com.ssafy.domain.user.service;

import com.ssafy.domain.koala.model.entity.Koala;
import com.ssafy.domain.user.model.dto.request.UserAddRequest;
import com.ssafy.domain.user.model.entity.Auth;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.domain.user.repository.UserRepository;
import com.ssafy.global.auth.jwt.JwtTokenProvider;
import com.ssafy.global.auth.jwt.dto.JwtToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
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
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;


    // 회원가입
    @Transactional
    public void signUp(UserAddRequest userAddRequest) {
        Auth auth = new Auth("user");
        User user = new User(
                userAddRequest.getLoginId(),
                userAddRequest.getPassword(),
                auth, userAddRequest.getName(),
                userAddRequest.getNickname(),
                0, 0L, 1);

        userRepository.save(user);
//        Koala koala = new Koala(user, "코알라", 0, 0, 0);
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
