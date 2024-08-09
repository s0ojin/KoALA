package com.ssafy.domain.chat.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatFinishResponse {

	private String message = "finish AI chat";

	private int leaves;

	public static ChatFinishResponse toDto(int leaves) {
		return ChatFinishResponse.builder()
			.leaves(leaves)
			.build();
	}
}
