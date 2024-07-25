package com.ssafy.domain.user.model.dto.request;

import com.ssafy.domain.user.model.entity.Auth;
import com.ssafy.domain.user.model.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private String loginId;
    private String password;
    private String name;
    private String nickname;
    private Integer leaves;
    private Long userExp;
    private Integer userLevel;
    private LocalDateTime userCreatedAt;
    private Auth auth;

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .loginId(user.getLoginId())
                .password(user.getPassword()) // 이미 인코딩된 비밀번호를 사용
                .name(user.getName())
                .nickname(user.getNickname())
                .leaves(user.getLeaves())
                .userExp(user.getUserExp())
                .userLevel(user.getUserLevel())
                .userCreatedAt(user.getUserCreatedAt())
                .auth(user.getAuth())
                .build();
    }

    public User toEntity(String encodedPassword) {
        return User.builder()
                .loginId(this.loginId)
                .password(encodedPassword) // 인코딩된 비밀번호 사용
                .auth(this.auth)
                .name(this.name)
                .nickname(this.nickname)
                .leaves(this.leaves)
                .userExp(this.userExp)
                .userLevel(this.userLevel)
                .build();
    }
}
