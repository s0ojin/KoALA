package com.ssafy.domain.user.service;

import com.ssafy.domain.user.model.dto.request.UserSignUpRequest;
import com.ssafy.domain.user.model.dto.request.UserUpdateRequest;
import com.ssafy.domain.user.model.dto.response.UserFindResponse;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.global.auth.jwt.dto.JwtToken;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    public UserResponse signUp(UserSignUpRequest userSignUpRequest);
    public JwtToken signIn(String loginId, String password);
    public JwtToken generateNewAccessToken(String refreshToken);

    public boolean checkLoginId(String loginId);
    public boolean checkNickname(String nickname);

    public UserFindResponse findUser();
    public UserResponse updateUser(UserUpdateRequest userUpdateRequest);
    public void deleteUser();
}
