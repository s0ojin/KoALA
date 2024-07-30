package com.ssafy.domain.chat.controller;

import com.ssafy.domain.chat.dto.request.ChatRequest;
import com.ssafy.domain.chat.dto.response.ChatResponse;
import com.ssafy.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;
    @PostMapping
    public ResponseEntity<ChatResponse> sendMessage (@RequestBody ChatRequest chatRequest) {
        log.info("chat request: {}", chatRequest.getMessage());
        return ResponseEntity.ok().body(chatService.getAIResponse(chatRequest));
    }
}
