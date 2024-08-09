package com.ssafy.domain.ai_talk.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class AiTalkSituationRequest {
	private String place;
	@JsonProperty("ai_role")
	private String aiRole;
	@JsonProperty("user_role")
	private String userRole;
}
