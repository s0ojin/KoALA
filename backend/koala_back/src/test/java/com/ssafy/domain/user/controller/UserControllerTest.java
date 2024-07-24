package com.ssafy.domain.user.controller;

import com.ssafy.domain.user.model.dto.request.SignUpDto;
import com.ssafy.domain.user.model.dto.request.UserDto;
import com.ssafy.domain.user.model.entity.Auth;
import com.ssafy.domain.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class UserControllerTest {

    @Autowired
    UserService userService;
    @Autowired
    // HTTP 요청 후 JSON, xml, String과 같은 응답을 받을 수 있는 HTTP 통신 템플릿
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    int randomServerPort;
    private SignUpDto signUpDto;

    @BeforeEach
    void beforeEach() {
        // Member 회원가입
        signUpDto = SignUpDto.builder()
                .loginId("test1")
                .password("test")
                .name("싸피짱")
                .nickname("싸피짱")
                .build();
    }


    @Test
    @Transactional
    @Rollback
    void signUp() {
        String url = "http://localhost:" + randomServerPort + "/users";
        ResponseEntity<UserDto> responseEntity = testRestTemplate.postForEntity(url, signUpDto, UserDto.class);

        // 응답 검증
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        UserDto savedUserDto = responseEntity.getBody();
        assertThat(savedUserDto).isNotNull();
        assertThat(savedUserDto.getLoginId()).isEqualTo(signUpDto.getLoginId());
        assertThat(savedUserDto.getName()).isEqualTo(signUpDto.getName());
        assertThat(savedUserDto.getNickname()).isEqualTo(signUpDto.getNickname());

    }

    @Test
    void signIn() {

    }
}