package com.ssafy.domain.user.controller;

import com.ssafy.domain.user.model.dto.request.UserAddRequest;
import com.ssafy.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 회원가입 성공하면 {
    //	"message": "회원가입 성공!"
    //} 반환
    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody JSONObject jsonObject) {
        UserAddRequest userAddRequest = new UserAddRequest(jsonObject);
        userService.signUp(userAddRequest);
        return ResponseEntity.ok().body("회원가입 성공!");
    }

}
