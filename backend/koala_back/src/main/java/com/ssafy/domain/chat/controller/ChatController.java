package com.ssafy.domain.chat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.chat.dto.request.ChatRequest;
import com.ssafy.domain.chat.dto.response.ChatResponse;
import com.ssafy.domain.chat.service.ChatService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
	public ResponseEntity<ChatResponse> sendMessage(@Valid @RequestBody ChatRequest chatRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(chatService.getAIResponse(chatRequest));
	}
}
