package com.ssafy.domain.lecture.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LectureChatRequest {
	// ENTER (들어왔을 경우), NOTICE (공지글), TALK (일반 채팅)
	@JsonProperty("message_type")
	private String messageType;
	@JsonProperty("lecture_id")
	private Long lectureId;
	private String message;
}
