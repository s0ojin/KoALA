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
import com.ssafy.domain.chat.dto.request.ChatSituationRequest;
import com.ssafy.domain.chat.dto.request.GPTRequest;
import com.ssafy.domain.chat.dto.request.GPTSituationRequest;
import com.ssafy.domain.chat.dto.response.ChatFinishResponse;
import com.ssafy.domain.chat.dto.response.ChatResponse;
import com.ssafy.domain.chat.dto.response.GPTResponse;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.domain.user.repository.UserRepository;
import com.ssafy.domain.user.service.AiTalkLogService;
import com.ssafy.domain.user.service.StudyTimeService;
import com.ssafy.global.common.UserInfoProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

	private final UserInfoProvider userInfoProvider;
	private final UserRepository userRepository;
	private final CacheService cacheService;
	private final StudyTimeService studyTimeService;
	private final AiTalkLogService aiTalkLogService;

	@Value("${openai.api.key}")
	private String apiKey;

	private final WebClient webClient = WebClient.builder()
		.baseUrl("https://api.openai.com/v1/")
		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.build();

	@Override
	public ChatResponse setSituation(ChatSituationRequest chatSituationRequest) {
		Long userId = userInfoProvider.getCurrentUserId();
		aiTalkLogService.createStartTimeLog(userId);

		String loginId = userInfoProvider.getCurrentLoginId();
		cacheService.initCacheMemory(loginId, chatSituationRequest);
		GPTSituationRequest gptSituationRequest = new GPTSituationRequest(chatSituationRequest);
		GPTResponse gptResponse = webClient.method(HttpMethod.POST)
			.uri("chat/completions")
			.header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
			.bodyValue(gptSituationRequest)
			.retrieve()
			.bodyToMono(GPTResponse.class)
			.block();

		String aiResponse = gptResponse.getChoices().get(0).getMessage().getContent();
		cacheService.addChatHistory(loginId, new Message("assistant", aiResponse));
		return new ChatResponse(aiResponse);
	}

	@Override
	public ChatResponse getAIResponse(ChatRequest chatRequest) {
		String loginId = userInfoProvider.getCurrentLoginId();
		// 이전 대화 가져오기
		List<Message> chatHistory = cacheService.getChatHistory(loginId);
		log.info(chatHistory.toString());
		GPTRequest gptRequest = new GPTRequest(chatHistory);
		gptRequest.addMessage(chatRequest.getMessage());

		GPTResponse gptResponse = webClient.method(HttpMethod.POST)
			.uri("chat/completions")
			.header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
			.bodyValue(gptRequest)
			.retrieve()
			.bodyToMono(GPTResponse.class)
			.block();

		String aiResponse = gptResponse.getChoices().get(0).getMessage().getContent();

		cacheService.addChatHistory(loginId, new Message("user", chatRequest.getMessage()));
		cacheService.addChatHistory(loginId, new Message("assistant", aiResponse));

		return new ChatResponse(aiResponse);
	}

	@Override
	public ChatFinishResponse finishAIResponse() {
		// 이외에 AI 응답 끝내는 로직 추가
		User user = userInfoProvider.getCurrentUser();
		cacheService.clearChatHistory(user.getLoginId());

		aiTalkLogService.createEndTimeLog(user.getUserId());
		Integer leaves = calculateLeaves(studyTimeService.increaseAiTalkMinutes());

		user.increaseUserLeaves(leaves);
		userRepository.save(user);

		return ChatFinishResponse.toDto(leaves);

	}

	public Integer calculateLeaves(Integer aiTalkTime) {
		if (aiTalkTime >= 15)
			return 10;
		if (aiTalkTime >= 8)
			return 5;
		if (aiTalkTime >= 5)
			return 3;
		if (aiTalkTime >= 2)
			return 1;
		return 0;
	}
}
