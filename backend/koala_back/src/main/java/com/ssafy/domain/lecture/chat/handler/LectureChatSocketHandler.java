package com.ssafy.domain.lecture.chat.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.domain.lecture.chat.LectureChatMessage;
import com.ssafy.domain.lecture.chat.LectureChatRoom;
import com.ssafy.domain.lecture.chat.LectureChatRoomManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class LectureChatSocketHandler extends TextWebSocketHandler {
	// 멀티쓰레드를 지원하는 HashMap - 처음으로 접속되었을 때 생성됨
	private final ObjectMapper objectMapper;
	private final LectureChatRoomManager lectureChatRoomManager;

	@Override // 웹 소켓 연결시
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info(session + " 클라이언트 접속");
	}

	@Override // 데이터 통신시
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		log.info("데이터 전송 payload : " + payload);
		LectureChatMessage chatMessage = objectMapper.readValue(payload, LectureChatMessage.class);
		LectureChatRoom chatRoom = lectureChatRoomManager.getRoomSessions().get(chatMessage.getLectureId());
		if (chatMessage.getMessageType().equals("ENTER")) {
			lectureChatRoomManager.getSessionToRoom().put(session.getId(), chatMessage.getLectureId());
			LectureChatMessage welcomeMessage = LectureChatMessage.builder()
				.messageType("NOTICE")
				.sender("admin")
				.message(chatMessage.getSender() + "님! 수업 참여를 환영합니다!^^ 웰컴")
				.build();
			String jsonMessage = objectMapper.writeValueAsString(welcomeMessage);
			chatRoom.sendWelcomeMessage(session, jsonMessage);
		} else {
			// 현재는 사용자가 보낼 수 있는 type이 enter과 talk 뿐이라 else로 처리
			String jsonMessage = objectMapper.writeValueAsString(chatRoom);
			chatRoom.sendMessage(session.getId(), jsonMessage);
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("세션 종료: " + session.getId() + " 상태: " + status);
		Long lectureId = lectureChatRoomManager.getSessionToRoom().remove(session.getId());
		if (lectureId != null) {
			LectureChatRoom chatRoom = lectureChatRoomManager.getRoomSessions().get(lectureId);
			if (chatRoom != null) {
				chatRoom.removeSession(session.getId());
			}
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.error("웹소켓 오류: " + session + " 오류: " + exception.getMessage());
	}
}
