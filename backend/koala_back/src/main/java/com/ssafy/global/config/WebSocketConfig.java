//package com.ssafy.global.config;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//@Configuration
//@EnableWebSocket // WebSocket을 활성화
//@RequiredArgsConstructor
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    private final ChatWebSocketHandler chatWebSocketHandler;
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        // WebSocketHandlerRegistry: WebSocket 핸들러를 등록하는 데 사용되는 클래스
//        //  WebSocket 연결이 수립되었을 때 어떤 핸들러가 해당 연결을 처리할지를 설정
//        registry.addHandler(chatWebSocketHandler, "/ws/chat")
//                .setAllowedOrigins("*");
//    }
//}