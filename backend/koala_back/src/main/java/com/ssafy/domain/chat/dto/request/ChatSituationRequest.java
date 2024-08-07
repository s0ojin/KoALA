package com.ssafy.domain.chat.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ChatSituationRequest {
	private String place;
	@JsonProperty("ai_role")
	private String aiRole;
	@JsonProperty("user_role")
	private String userRole;
}
