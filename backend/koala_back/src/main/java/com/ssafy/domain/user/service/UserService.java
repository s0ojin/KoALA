package com.ssafy.domain.user.service;

import com.ssafy.domain.user.model.dto.request.UserAddRequest;
import com.ssafy.global.auth.jwt.dto.JwtToken;

public interface UserService {
    public JwtToken signIn(String loginId, String password);
    public void signUp(UserAddRequest userAddRequest);
}
