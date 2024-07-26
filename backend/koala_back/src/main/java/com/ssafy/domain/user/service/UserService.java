package com.ssafy.domain.user.service;

import com.ssafy.domain.user.model.dto.request.UserSignUpRequest;
import com.ssafy.domain.user.model.dto.request.UserUpdateRequest;
import com.ssafy.domain.user.model.dto.response.UserFindResponse;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.global.auth.jwt.dto.JwtToken;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    public JwtToken signIn(String loginId, String password);
    public UserResponse signUp(UserSignUpRequest userSignUpRequest);
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest);
    public void deleteUser(User user);
    public UserFindResponse findUser();

    public JwtToken generateNewAccessToken(String refreshToken);

    public boolean checkLoginId(String loginId);
    public boolean checkNickname(String nickname);
}
