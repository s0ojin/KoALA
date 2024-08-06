package com.ssafy.domain.chat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssafy.domain.chat.dto.Message;
import com.ssafy.domain.chat.dto.request.ChatSituationRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {
	private static final int MAX_HISTORY_SIZE = 10;
	private final CacheManager cacheManager;

	@Override
	@SuppressWarnings("unchecked")
	public boolean isEmpty(String loginId) {
		Cache cache = cacheManager.getCache("chatHistory");
		if (cache != null) {
			List<Message> chatHistory = cache.get(loginId, List.class);
			if (chatHistory == null || chatHistory.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void initCacheMemory(String loginId, ChatSituationRequest chatSituationRequest) {
		// 해당하는 캐시가 있으면 지우고 생성한다
		Cache cache = cacheManager.getCache("chatHistory");
		cache.evict(loginId);
		String defaultPrompt = "당신은 한국어 회화 초보를 돕는 AI 회화 도우미입니다. "
			+ "당신은 " + chatSituationRequest.getPlace() + " 에서 대화 중입니다. "
			+ "상대방은 " + chatSituationRequest.getUserRole() + "역할입니다. "
			+ "당신은 " + chatSituationRequest.getAiRole() + "역할입니다. "
			+ "이어서 대답을 해주세요.";
		log.info("캐시 생성");

		List<Message> initialChatHistory = new ArrayList<>();
		initialChatHistory.add(new Message("system", defaultPrompt));
		cache.put(loginId, initialChatHistory);
	}


	// loginId에 해당하는 채팅 기록을 가져온다
	// 캐시에 해당 데이터가 없으면 새로운 빈 리스트를 반환, 캐시 키: #loginId
	@Override
	public List<Message> getChatHistory(String loginId) {
		return cacheManager.getCache("chatHistory").get(loginId, List.class); // 새로운 대화 시 빈 리스트 반환
	}

	// 기존 채팅 기록에 추가하고, 갱신된 채팅 기록을 캐시에 저장
	@Override
	@CachePut(value = "chatHistory", key = "#loginId")
	public void addChatHistory(String loginId, Message message) {
		log.info("메시지를 추가합니다.");
		List<Message> chatHistory = cacheManager.getCache("chatHistory").get(loginId, List.class);
		chatHistory.add(message);
		// 리스트 크기가 MAX_HISTORY_SIZE를 초과하면 가장 오래된 메시지 삭제
		if (chatHistory.size() > MAX_HISTORY_SIZE) {
			chatHistory.remove(0); // 가장 오래된 메시지 삭제
		}

	}

	// 주어진 loginId에 해당하는 채팅 기록을 캐시에서 삭제
	@Override
	@CacheEvict(value = "chatHistory", key = "#loginId")
	public void clearChatHistory(String loginId) {
		// 캐시에서 대화 기록 삭제
	}
}
