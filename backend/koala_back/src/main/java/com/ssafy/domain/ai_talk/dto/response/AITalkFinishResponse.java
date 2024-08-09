package com.ssafy.domain.ai_talk.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AITalkFinishResponse {

	private String message = "finish AI chat";

	private int leaves;

	public static AITalkFinishResponse toDto(int leaves) {
		return AITalkFinishResponse.builder()
			.leaves(leaves)
			.build();
	}
}
