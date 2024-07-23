package com.ssafy.domain.user.service;

import com.ssafy.global.auth.jwt.dto.JwtToken;

public interface UserService {
    public JwtToken signIn(String loginId, String password);
}
