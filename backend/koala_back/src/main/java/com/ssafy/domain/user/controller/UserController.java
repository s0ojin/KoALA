package com.ssafy.domain.user.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.user.model.dto.request.UserSignInRequest;
import com.ssafy.domain.user.model.dto.request.UserSignUpRequest;
import com.ssafy.domain.user.model.dto.request.UserUpdateRequest;
import com.ssafy.domain.user.model.dto.response.UserFindResponse;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.domain.user.repository.UserRepository;
import com.ssafy.domain.user.service.UserService;
import com.ssafy.global.auth.jwt.JwtTokenProvider;
import com.ssafy.global.auth.jwt.dto.JwtToken;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        UserResponse savedUserResponse = userService.signUp(userSignUpRequest); // 이걸 반환해도 됨
        System.out.println(savedUserResponse.getNickname());
//        return ResponseEntity.ok().body(savedUserResponse);
        return ResponseEntity.ok().body(new JSONObject().put("message", "Signup successful").toString());
    }


    @PostMapping("/login")
    public ResponseEntity<JwtToken> signIn(@RequestBody UserSignInRequest userSignInRequest) {
        String loginId = userSignInRequest.getLoginId();
        String password = userSignInRequest.getPassword();
        JwtToken jwtToken = userService.signIn(loginId, password);
        log.info("request loginId: {}, password: {}", loginId, password);
        log.info("jwtToken accessToken: {}, refreshToken: {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return ResponseEntity.ok().body(jwtToken);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody String accessToken) {
//        userService.logout(accessToken);
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok().body("logout successful");
    }

    @GetMapping("/check/check-id/{loginId}")
    public ResponseEntity<?> checkLoginId(@PathVariable String loginId) {
        boolean isExist = userService.checkLoginId(loginId);
        String message = isExist ? "이미 사용 중인 아이디입니다." : "사용 가능한 아이디입니다.";
        return ResponseEntity.ok().body(new JSONObject().put("available", !isExist).put("message", message).toString());
    }

    @GetMapping("/check/check-name/{nickname}")
    public ResponseEntity<?> checkNickname(@PathVariable String nickname) {
        boolean isExist = userService.checkNickname(nickname);
        String message = isExist ? "Not Available Nickname" : "Available Nickname";
        return ResponseEntity.ok().body(new JSONObject().put("available", !isExist).put("message", message).toString());
    }

    @GetMapping
    public ResponseEntity<?> getUser() {
        UserFindResponse userFindResponse = userService.findUser();
        return ResponseEntity.ok().body(userFindResponse);
    }


    @PatchMapping
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        UserResponse userResponse = userService.updateUser(userUpdateRequest);
//        return ResponseEntity.ok().body(userResponse);
        return ResponseEntity.ok().body(new JSONObject().put("message", "Update successful").toString());
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser() {
        userService.deleteUser();
        return ResponseEntity.ok().body(new JSONObject().put("message", "Delete successful").toString());
    }

}
