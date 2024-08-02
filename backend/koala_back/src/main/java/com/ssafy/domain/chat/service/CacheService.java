package com.ssafy.domain.chat.service;

import java.util.List;

import com.ssafy.domain.chat.dto.Message;

public interface CacheService {
	public List<Message> getChatHistory(String loginId);

	public List<Message> updateChatHistory(String loginId, Message message);

	public void clearChatHistory(String loginId);
}
