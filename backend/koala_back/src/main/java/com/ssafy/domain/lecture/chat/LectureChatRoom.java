package com.ssafy.domain.lecture.chat;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
public class LectureChatRoom {
	private Long lectureId;
	private static final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

	public LectureChatRoom(Long lectureId) {
		this.lectureId = lectureId;
	}

	public void sendMessage(String sessionId, String jsonMessage) {
		sessions.values().forEach(s -> {
			try {
				if (!s.getId().equals(sessionId)) {
					s.sendMessage(new TextMessage(jsonMessage));
				}
			} catch (IOException e) {
				log.error("채팅 전송 실패: " + e.getMessage());
			}
		});
	}

	public void sendWelcomeMessage(WebSocketSession s, String jsonMessage) {
		sessions.put(s.getId(), s);
		try {
			s.sendMessage(new TextMessage(jsonMessage));
		} catch (IOException e) {
			log.error("환영 메시지 전송 실패: " + e.getMessage());
		}
	}

	public void removeSession(String sessionId) {
		sessions.remove(sessionId);
		log.info("세션 제거: " + sessionId);
	}

	public boolean isEmpty() {
		return sessions.isEmpty();
	}

}
