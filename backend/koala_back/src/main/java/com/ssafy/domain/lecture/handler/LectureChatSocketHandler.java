package com.ssafy.domain.lecture.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.domain.lecture.model.dto.LectureChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
@RequiredArgsConstructor
public class LectureChatSocketHandler extends TextWebSocketHandler {
    // 멀티쓰레드를 지원하는 HashMap - 처음으로 접속되었을 때 생성됨
    private final ObjectMapper objectMapper;
    private Long lectureId;

    ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    ConcurrentHashMap<Long, ConcurrentHashMap<String, WebSocketSession>> roomSessions = new ConcurrentHashMap<>();

    @Override // 웹 소켓 연결시
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
        log.info(session + " 클라이언트 접속");
//        LectureChatMessage chatMessage = LectureChatMessage.builder()
//                .messageType("notice")
//                .sender("admin")
//                .message("수업 참여를 환영합니다!^^ (THANK YOU)")
//                .receiver(session.getId())
//                .build();
//        // ObjectMapper를 사용하여 LectureChatResponse 객체를 JSON 문자열로 변환
//        String jsonMessage = objectMapper.writeValueAsString(chatMessage);
//
//        // 변환된 JSON 문자열을 TextMessage에 전달
//        session.sendMessage(new TextMessage(jsonMessage));
    }

    @Override // 데이터 통신시
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : " + payload);
        LectureChatMessage chatMessage = objectMapper.readValue(payload, LectureChatMessage.class);
        ConcurrentHashMap<String, WebSocketSession> roomSession = roomSessions.get(chatMessage.getLectureId());
        if (chatMessage.getMessageType().equals("ENTER")) {
            // 처음들어왔음
            roomSession.put(session.getId(), session);
            LectureChatMessage welcomeMessage = LectureChatMessage.builder()
                    .messageType("NOTICE")
                    .sender("admin")
                    .message(chatMessage.getSender() + "님! 수업 참여를 환영합니다!^^ 웰컴")
                    .receiver(chatMessage.getSender())
                .build();
            sendMessage(session.getId(), welcomeMessage);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }

    @Override // 웹
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        sessions.remove(session.getId());
    }

    private void sendMessage(String sessionId, LectureChatMessage chatMessage) throws IOException {
        String jsonMessage = objectMapper.writeValueAsString(chatMessage);

        roomSessions.get(chatMessage.getLectureId()).values().forEach(s -> {
            try {
                if (!s.getId().equals(sessionId)) {
                    s.sendMessage(new TextMessage(jsonMessage));
                }
            } catch (IOException e) {
                log.error("채팅 전송 실패: " + e.getMessage());
            }
        });
    }

    /*
    https://brunch.co.kr/@springboot/695
    https://velog.io/@kevin_/Spring-%EC%B1%84%ED%8C%85-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-1.-WebSocket
    https://wans1027.tistory.com/19
    https://velog.io/@sunkyuj/Spring-%EC%9B%B9%EC%86%8C%EC%BC%93%EC%9C%BC%EB%A1%9C-%EC%8B%A4%EC%8B%9C%EA%B0%84-%EC%B1%84%ED%8C%85-%EA%B5%AC%ED%98%84
    https://velog.io/@joonoo3/Spring-WebSocket%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%8B%A4%EC%8B%9C%EA%B0%84-%EC%B1%84%ED%8C%85
    https://velog.io/@mw310/Stomp-WebSocket-%EA%B0%9C%EB%85%90-%EC%A0%95%EB%A6%ACver-Spring
    https://velog.io/@guswns3371/WebSocket-Spring
    https://dev-gorany.tistory.com/212
    https://dev-gorany.tistory.com/3


     */

}
