package com.ssafy.domain.ai_talk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ssafy.domain.ai_talk.dto.Message;
import com.ssafy.domain.ai_talk.dto.request.AITalkRequest;
import com.ssafy.domain.ai_talk.dto.request.AITalkSituationRequest;
import com.ssafy.domain.ai_talk.dto.request.GPTRequest;
import com.ssafy.domain.ai_talk.dto.request.GPTSituationRequest;
import com.ssafy.domain.ai_talk.dto.response.AITalkResponse;
import com.ssafy.domain.ai_talk.dto.response.GPTResponse;
import com.ssafy.domain.user.service.AiTalkLogService;
import com.ssafy.domain.user.service.StudyTimeService;
import com.ssafy.global.common.UserInfoProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AITalkServiceImpl implements AITalkService {

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
	public AITalkResponse setSituation(AITalkSituationRequest AITalkSituationRequest) {
		Long userId = userInfoProvider.getCurrentUserId();
		aiTalkLogService.createStartTimeLog(userId);

		String loginId = userInfoProvider.getCurrentLoginId();
		cacheService.initCacheMemory(loginId, AITalkSituationRequest);
		GPTSituationRequest gptSituationRequest = new GPTSituationRequest(AITalkSituationRequest);
		GPTResponse gptResponse = webClient.method(HttpMethod.POST)
			.uri("chat/completions")
			.header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
			.bodyValue(gptSituationRequest)
			.retrieve()
			.bodyToMono(GPTResponse.class)
			.block();

		String aiResponse = gptResponse.getChoices().get(0).getMessage().getContent();
		cacheService.addChatHistory(loginId, new Message("assistant", aiResponse));
		return new AITalkResponse(aiResponse);
	}

	@Override
	public AITalkResponse getAIResponse(AITalkRequest AITalkRequest) {
		String loginId = userInfoProvider.getCurrentLoginId();
		// 이전 대화 가져오기
		List<Message> chatHistory = cacheService.getChatHistory(loginId);
		log.info(chatHistory.toString());
		GPTRequest gptRequest = new GPTRequest(chatHistory);
		gptRequest.addMessage(AITalkRequest.getMessage());

		GPTResponse gptResponse = webClient.method(HttpMethod.POST)
			.uri("chat/completions")
			.header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
			.bodyValue(gptRequest)
			.retrieve()
			.bodyToMono(GPTResponse.class)
			.block();

		String aiResponse = gptResponse.getChoices().get(0).getMessage().getContent();

		cacheService.addChatHistory(loginId, new Message("user", AITalkRequest.getMessage()));
		cacheService.addChatHistory(loginId, new Message("assistant", aiResponse));

		return new AITalkResponse(aiResponse);
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
