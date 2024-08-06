package com.ssafy.domain.chat.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.chat.dto.request.ChatRequest;
import com.ssafy.domain.chat.dto.response.ChatResponse;
import com.ssafy.domain.chat.service.ChatService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
	private final ChatService chatService;

	@Operation(summary = "AI 회화 메세지 전송")
	@PostMapping
	public ResponseEntity<?> sendMessage(@Valid @RequestBody ChatRequest chatRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(chatService.getAIResponse(chatRequest));
	}

	@Operation(summary = "AI 회화 끝내기")
	@GetMapping("/close")
	public ResponseEntity<?> closeChat() {
		chatService.finishAIResponse();
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "finish AI chat"));
	}
}
