package com.ssafy.domain.user.service;

import com.ssafy.domain.user.model.dto.request.SignUpDto;
import com.ssafy.domain.user.model.dto.request.UserDto;
import com.ssafy.global.auth.jwt.dto.JwtToken;

public interface UserService {
    public JwtToken signIn(String loginId, String password);
    public UserDto signUp(SignUpDto signUpDto);
    public JwtToken generateNewAccessToken(String refreshToken);
}
