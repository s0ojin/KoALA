package com.ssafy.domain.ai_talk.dto.request;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.domain.ai_talk.dto.Message;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class GPTRequest {

	private final String model = "gpt-4o-mini";
	private List<Message> messages;

	public GPTRequest(List<Message> chatHistory) {
		messages = new ArrayList<>(chatHistory);
	}

	public void addMessage(String message) {
		this.messages.add(new Message("user", message));
	}
}
