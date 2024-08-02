package com.ssafy.domain.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ssafy.domain.chat.dto.Message;
import com.ssafy.domain.chat.dto.request.ChatRequest;
import com.ssafy.domain.chat.dto.request.GPTRequest;
import com.ssafy.domain.chat.dto.response.ChatResponse;
import com.ssafy.domain.chat.dto.response.GPTResponse;
import com.ssafy.global.common.UserInfoProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

	private final UserInfoProvider userInfoProvider;
	private final CacheService cacheService;
	@Value("${openai.api.key}")
	private String apiKey;

	private final WebClient webClient = WebClient.builder()
		.baseUrl("https://api.openai.com/v1/")
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.build();

	@Override
	public ChatResponse getAIResponse(ChatRequest chatRequest) {
		String loginId = userInfoProvider.getCurrentLoginId();

		// 이전 대화 가져오기
		List<Message> chatHistory = cacheService.getChatHistory(loginId);

		GPTRequest gptRequest = new GPTRequest(chatRequest.getSituation(), chatHistory);
		gptRequest.addMessage(chatRequest.getMessage());

		GPTResponse gptResponse = webClient.method(HttpMethod.POST)
			.uri("chat/completions")
			.header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
			.bodyValue(gptRequest)
			.retrieve()
			.bodyToMono(GPTResponse.class)
			.block();

		String aiResponse = gptResponse.getChoices().get(0).getMessage().getContent();

		cacheService.updateChatHistory(loginId, new Message("user", chatRequest.getMessage()));
		cacheService.updateChatHistory(loginId, new Message("assistant", aiResponse));

		return new ChatResponse(aiResponse);
	}
}
