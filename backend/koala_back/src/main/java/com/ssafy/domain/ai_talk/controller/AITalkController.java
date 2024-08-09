package com.ssafy.domain.ai_talk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.ai_talk.dto.request.AITalkRequest;
import com.ssafy.domain.ai_talk.dto.request.AITalkSituationRequest;
import com.ssafy.domain.ai_talk.dto.response.AITalkResponse;
import com.ssafy.domain.ai_talk.service.AITalkService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class AITalkController {
	private final AITalkService talkService;

	@PostMapping("/start")
	public ResponseEntity<AITalkResponse> createChat(
		@RequestBody @Valid AITalkSituationRequest aiTalkSituationRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(talkService.setSituation(aiTalkSituationRequest));
	}

	@Operation(summary = "AI 회화 메세지 전송")
	@PostMapping
	public ResponseEntity<?> sendMessage(@Valid @RequestBody AITalkRequest aiTalkRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(talkService.getAIResponse(aiTalkRequest));
	}

	@Operation(summary = "AI 회화 끝내기")
	@GetMapping("/finish")
	public ResponseEntity<?> closeChat() {
		return ResponseEntity.status(HttpStatus.OK).body(talkService.finishAIResponse());
	}
}
