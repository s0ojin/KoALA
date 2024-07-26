package com.ssafy.domain.user.controller;

import com.ssafy.domain.user.model.dto.request.UserSignUpRequest;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.domain.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
    private UserSignUpRequest userSignUpRequest;

    @BeforeEach
    void beforeEach() {
        // Member 회원가입
        userSignUpRequest = UserSignUpRequest.builder()
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
        ResponseEntity<UserResponse> responseEntity = testRestTemplate.postForEntity(url, userSignUpRequest, UserResponse.class);

        // 응답 검증
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        UserResponse savedUserResponse = responseEntity.getBody();
//        assertThat(savedUserDto).isNotNull();
        assertThat(savedUserResponse.getLoginId()).isEqualTo(userSignUpRequest.getLoginId());
        assertThat(savedUserResponse.getName()).isEqualTo(userSignUpRequest.getName());
        assertThat(savedUserResponse.getNickname()).isEqualTo(userSignUpRequest.getNickname());
//        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url, signUpDto, String.class);
//
//        // 응답 검증
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        String message = responseEntity.getBody();
//        assertThat(message).isEqualTo("회원가입 성공!");


    }

    @Test
    void signIn() {

    }
}