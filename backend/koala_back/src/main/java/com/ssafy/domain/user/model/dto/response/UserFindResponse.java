package com.ssafy.domain.user.model.dto.response;

import com.ssafy.domain.user.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserFindResponse {

	private Long userId;
	private String longinId;
	private String nickname;
	private String name;

	public static UserFindResponse toDto(User user) {
		return UserFindResponse.builder()
			.userId(user.getUserId())
			.longinId(user.getLoginId())
			.nickname(user.getNickname())
			.name(user.getName())
			.build();
	}
}
