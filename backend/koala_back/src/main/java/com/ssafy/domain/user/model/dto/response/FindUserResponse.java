package com.ssafy.domain.user.model.dto.response;

import com.ssafy.domain.user.model.entity.User;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserResponse {
    private Long userId;
    private String longinId;
    private String nickname;
    private String name;

    public static FindUserResponse toDto(User user) {
        return FindUserResponse.builder()
                .userId(user.getUserId())
                .longinId(user.getLoginId())
                .nickname(user.getNickname())
                .name(user.getName())
                .build();
    }
}
