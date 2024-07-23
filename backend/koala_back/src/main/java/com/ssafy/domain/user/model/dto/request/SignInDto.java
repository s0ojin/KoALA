package com.ssafy.domain.user.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Service
@ToString
@NoArgsConstructor
public class SignInDto {
    private String loginId;
    private String password;
}
