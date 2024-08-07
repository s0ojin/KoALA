package com.ssafy.domain.chat.service;

import com.ssafy.domain.chat.dto.request.ChatRequest;
import com.ssafy.domain.chat.dto.request.ChatSituationRequest;
import com.ssafy.domain.chat.dto.response.ChatResponse;

public interface ChatService {
	ChatResponse setSituation(ChatSituationRequest chatSituationRequest);

	ChatResponse getAIResponse(ChatRequest chatRequest);

	void finishAIResponse();
}
