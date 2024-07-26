package com.ssafy.domain.user.controller;

import com.ssafy.domain.user.model.dto.request.UserSignInRequest;
import com.ssafy.domain.user.model.dto.request.UserSignUpRequest;
import com.ssafy.domain.user.model.dto.request.UserUpdateRequest;
import com.ssafy.domain.user.model.dto.response.FindUserResponse;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.domain.user.service.UserService;
import com.ssafy.global.auth.jwt.dto.JwtToken;
import com.ssafy.global.common.UserInfoProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserInfoProvider userInfoProvider;

    // 회원가입 성공하면 {
    //	"message": "회원가입 성공!"
    //} 반환

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
//    public ResponseEntity<?> signUp(@RequestBody JSONObject jsonObject) {
//        SignUpDto signUpDto = new SignUpDto(jsonObject);
        UserResponse savedUserResponse = userService.signUp(userSignUpRequest); // 이걸 반환해도 됨
        System.out.println(savedUserResponse.getNickname());
//        return ResponseEntity.ok().body(savedUserResponse);
        return ResponseEntity.ok().body("Sign up successful");
    }

//    @GetMapping
//    public ResponseEntity<?> findUser(){
//        FindUserResponse findUserResponse =  userService.findUser();
//        return ResponseEntity.ok().body("Read successful");
//    }


    @PatchMapping
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        UserResponse userResponse = userService.updateUser(userUpdateRequest);
//        return ResponseEntity.ok().body(userResponse);
        return ResponseEntity.ok().body("Update successful");
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


    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody String refreshToken) {
        JwtToken newToken = userService.generateNewAccessToken(refreshToken);
        return ResponseEntity.ok(newToken);
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

    @DeleteMapping
    public ResponseEntity<?> deleteUser() {
        Optional<User> currentUser = userInfoProvider.getCurrentUser();
        if (!currentUser.isPresent()) {
            return ResponseEntity.badRequest().body("No user found");
        }
        userService.deleteUser(currentUser.get());
        return ResponseEntity.ok().body("Delete successful");
    }

}
