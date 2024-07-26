package com.ssafy.domain.user.service;

import com.ssafy.domain.user.model.dto.request.SignUpRequest;
import com.ssafy.domain.user.model.dto.request.UserUpdateRequest;
import com.ssafy.domain.user.model.dto.response.FindUserResponse;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.global.auth.jwt.dto.JwtToken;

public interface UserService {
    public JwtToken signIn(String loginId, String password);
    public UserResponse signUp(SignUpRequest signUpRequest);
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest);
    public void deleteUser(Long userId);
    //public FindUserResponse findUser();

    public JwtToken generateNewAccessToken(String refreshToken);

    public boolean checkLoginId(String loginId);
    public boolean checkNickname(String nickname);
}
