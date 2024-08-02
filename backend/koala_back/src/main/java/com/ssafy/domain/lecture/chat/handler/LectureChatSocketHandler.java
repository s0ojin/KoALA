package com.ssafy.domain.lecture.chat.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.domain.lecture.chat.LectureChatRoom;
import com.ssafy.domain.lecture.chat.LectureChatRoomManager;
import com.ssafy.domain.lecture.model.dto.request.LectureChatRequest;
import com.ssafy.domain.lecture.model.dto.response.LectureChatResponse;
import com.ssafy.global.common.UserInfoProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class LectureChatSocketHandler extends TextWebSocketHandler {
	// 멀티쓰레드를 지원하는 HashMap - 처음으로 접속되었을 때 생성됨
	private final ObjectMapper objectMapper;
	private final LectureChatRoomManager lectureChatRoomManager;
	private final UserInfoProvider userInfoProvider;

	@Override // 웹 소켓 연결시
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info(session + " 클라이언트 접속");
	}

	@Override // 데이터 통신시
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		log.info("데이터 전송 payload : " + payload);
		LectureChatRequest chatMessage = objectMapper.readValue(payload, LectureChatRequest.class);
		LectureChatRoom chatRoom = lectureChatRoomManager.getRoomSessions().get(chatMessage.getLectureId());

		if (chatMessage.getMessageType().equals("ENTER")) {
			if (chatRoom == null) {
				log.debug("강의 채팅방이 존재하지 않아, 해당 강의장의 채팅방을 생성합니다.");
				chatRoom = new LectureChatRoom(chatMessage.getLectureId());
				lectureChatRoomManager.getRoomSessions().put(chatMessage.getLectureId(), chatRoom);
			}
			lectureChatRoomManager.getSessionToRoom().put(session.getId(), chatMessage.getLectureId());
			LectureChatResponse welcomeMessage = LectureChatResponse.builder()
				.messageType("NOTICE")
				.lectureId(chatMessage.getLectureId())
				.sender("admin")
				.message(userInfoProvider.getCurrentNickname() + "님! 수업 참여를 환영합니다!^^ 웰컴")
				.build();
			String jsonMessage = objectMapper.writeValueAsString(welcomeMessage);
			chatRoom.sendWelcomeMessage(session, jsonMessage);
		} else {
			// 현재는 사용자가 보낼 수 있는 type이 enter과 talk 뿐이라 else로 처리
			LectureChatResponse talkMessage = LectureChatResponse.builder()
				.messageType("TALK")
				.lectureId(chatMessage.getLectureId())
				.sender(userInfoProvider.getCurrentNickname())
				.message(chatMessage.getMessage())
				.build();
			String jsonMessage = objectMapper.writeValueAsString(talkMessage);
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
				if (chatRoom.isEmpty()) {
					lectureChatRoomManager.getRoomSessions().remove(lectureId);
					log.info("사용자가 없어 채팅방 삭제: " + lectureId);
				}
			}
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.error("웹소켓 오류: " + session + " 오류: " + exception.getMessage());
	}
}
