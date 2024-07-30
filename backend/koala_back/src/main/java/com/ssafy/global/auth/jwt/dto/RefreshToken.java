package com.ssafy.global.auth.jwt.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class RefreshToken {
    private String refreshToken;
}
