package com.ssafy.domain.user.service;

import com.ssafy.domain.user.model.dto.request.UserSignUpRequest;
import com.ssafy.domain.user.model.dto.request.UserUpdateRequest;
import com.ssafy.domain.user.model.dto.response.UserFindResponse;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.global.auth.jwt.dto.JwtToken;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    public UserResponse signUp(UserSignUpRequest userSignUpRequest);
    public JwtToken signIn(String loginId, String password);

    public boolean checkLoginId(String loginId);
    public boolean checkNickname(String nickname);

    public UserFindResponse findUser();
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest);
    public void deleteUser();

}
