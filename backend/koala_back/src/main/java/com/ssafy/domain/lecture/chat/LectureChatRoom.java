package com.ssafy.domain.lecture.chat;

import java.util.concurrent.ConcurrentHashMap;

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
	}
}
