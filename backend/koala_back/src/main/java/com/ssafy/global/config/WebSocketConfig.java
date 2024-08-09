package com.ssafy.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.ssafy.domain.lecture.chat.handler.LectureChatSocketHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

	private final LectureChatSocketHandler lectureChatSocketHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// WebSocketHandlerRegistry: WebSocket 핸들러를 등록하는 데 사용되는 클래스
		//  WebSocket 연결이 수립되었을 때 어떤 핸들러가 해당 연결을 처리할지를 설정
		registry.addHandler(lectureChatSocketHandler, "/lectures/chat").setAllowedOrigins("*");
	}
}