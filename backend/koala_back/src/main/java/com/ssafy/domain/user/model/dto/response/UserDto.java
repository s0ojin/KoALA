package com.ssafy.domain.user.model.dto.response;

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
    private Long authId;

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
                .authId(user.getAuth().getAuthId())
                .build();
    }
}
