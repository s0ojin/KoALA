package com.ssafy.global.auth.jwt.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtToken {
    private String grantType; //  Bearer
    private String accessToken;
    private String refreshToken;
}
