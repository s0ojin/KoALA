package com.ssafy.domain.user.model.dto.request;

import com.ssafy.domain.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Service
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    String nickname;
    String password;
    public User toEntity(String nickname, String encodedPassword){
        return User.builder()
                .nickname(nickname)
                .password(encodedPassword)
                .build();
    }
}
