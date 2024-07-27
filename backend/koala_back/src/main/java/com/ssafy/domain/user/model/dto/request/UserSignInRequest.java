package com.ssafy.domain.user.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UserSignInRequest {
	@JsonProperty("login_id")
	private String loginId;
	@JsonProperty("password")
	private String password;
}
