package com.ssafy.domain.user.model.dto.response;

import java.time.LocalDateTime;

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
public class UserResponse {

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

	public static UserResponse toDto(User user) {
		return UserResponse.builder()
			.userId(user.getUserId())
			.loginId(user.getLoginId())
			.password(user.getPassword())
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
