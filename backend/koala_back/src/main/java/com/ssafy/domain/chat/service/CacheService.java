package com.ssafy.domain.chat.service;

import java.util.List;

import com.ssafy.domain.chat.dto.Message;
import com.ssafy.domain.chat.dto.request.ChatSituationRequest;

public interface CacheService {
	boolean isEmpty(String loginId);

	void initCacheMemory(String loginId, ChatSituationRequest chatSituationRequest);

	List<Message> getChatHistory(String loginId);

	void addChatHistory(String loginId, Message message);

	void clearChatHistory(String loginId);
}
