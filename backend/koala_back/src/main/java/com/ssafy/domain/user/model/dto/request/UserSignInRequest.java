package com.ssafy.domain.user.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UserSignInRequest {
    private String loginId;
    private String password;
}
