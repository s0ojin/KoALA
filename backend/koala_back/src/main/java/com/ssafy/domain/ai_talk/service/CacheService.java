package com.ssafy.domain.ai_talk.service;

import java.util.List;

import com.ssafy.domain.ai_talk.dto.Message;
import com.ssafy.domain.ai_talk.dto.request.AiTalkSituationRequest;

public interface CacheService {
	boolean isEmpty(String loginId);

	void initCacheMemory(String loginId, AiTalkSituationRequest AITalkSituationRequest);

	List<Message> getChatHistory(String loginId);

	void addChatHistory(String loginId, Message message);

	void clearChatHistory(String loginId);
}
