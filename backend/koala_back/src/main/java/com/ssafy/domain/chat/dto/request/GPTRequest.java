package com.ssafy.domain.chat.dto.request;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.domain.chat.dto.Message;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class GPTRequest {
	private final String model = "gpt-4o-mini";
	private List<Message> messages;

	public GPTRequest(String situation, List<Message> chatHistory) {
		messages = new ArrayList<>(chatHistory);
		String role = getRole(situation);
		this.messages.add(new Message("system", "너는 한국어를 연습하고 있는 사람을 돕는 회화 도우미야. 쉬운 한국어로 짧게 대답해줘."));
		this.messages.add(
			new Message("system", "지금부터 너는 " + situation + " 에서 대화를 할 거야. 너는 " + role + " 역할이야." + "한국어로 친절하게 안내해줘."));
	}

	public void addMessage(String message) {
		this.messages.add(new Message("user", message));
	}

	private String getRole(String situation) {
		// 상황에 따라 역할을 반환하는 로직을 구현
		// "선생님" 역할을 반환
		return "선생님";
	}
}
