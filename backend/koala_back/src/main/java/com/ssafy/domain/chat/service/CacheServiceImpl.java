package com.ssafy.domain.chat.service;

import com.ssafy.domain.chat.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService{
    private static final int MAX_HISTORY_SIZE = 10;

    @Cacheable(value = "chatHistory", key = "#loginId")
    public List<Message> getChatHistory(String loginId) {
        return new ArrayList<>(); // 새로운 대화 시 빈 리스트 반환
    }

    @CachePut(value = "chatHistory", key = "#loginId")
    public List<Message> updateChatHistory(String loginId, Message message) {
        List<Message> chatHistory = getChatHistory(loginId);
        chatHistory.add(message);

        // 리스트 크기가 MAX_HISTORY_SIZE를 초과하면 가장 오래된 메시지 삭제
        if (chatHistory.size() > MAX_HISTORY_SIZE) {
            chatHistory.remove(0); // 가장 오래된 메시지 삭제
        }

        return chatHistory;
    }

    @CacheEvict(value = "chatHistory", key = "#loginId")
    public void clearChatHistory(String loginId) {
        // 캐시에서 대화 기록 삭제
    }
}
