package com.ssafy.global.auth.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // HTTP 기본 인증을 비활성화
                .httpBasic(HttpBasicConfigurer::disable)
                // REST API에서는 보통 CSRF 보호가 필요 X
                .csrf(CsrfConfigurer::disable)
                // JWT를 사용하여 상태를 유지하기 때문에 서버 측 세션이 필요 X
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // HTTP 요청에 대한 권한을 설정
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                // "/users/register" 경로에 대한 모든 요청을 허용
                                .requestMatchers(HttpMethod.POST, "/users").permitAll()
                                // 다른 모든 요청은 인증을 필요로 함
                                .anyRequest().authenticated()
                )
                // JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 이전에 실행되도록 추가
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
