package com.ssafy.domain.lecture.model.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class LectureChatRoom {
    private Long lectureId;
    private static final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    private void sendMessage(String sessionId, String jsonMessage) {
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

}
