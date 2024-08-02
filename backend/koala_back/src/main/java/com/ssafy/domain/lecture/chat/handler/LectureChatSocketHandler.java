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

}
