package com.ssafy.domain.ai_talk.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AiTalkSituationResponse {
	@JsonProperty("situation_id")
	private Long situationId;

	@JsonProperty("situation_title")
	private String situationTitle;

	@JsonProperty("situation_detail")
	private String situationDetail;

	@JsonProperty("situation_place")
	private String situationPlace;

	@JsonProperty("situation_img_url")
	private String situationImgUrl;
}
