package com.ssafy.domain.ai_talk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.ai_talk.dto.request.AiTalkRequest;
import com.ssafy.domain.ai_talk.dto.request.AiTalkSituationRequest;
import com.ssafy.domain.ai_talk.dto.response.AiTalkResponse;
import com.ssafy.domain.ai_talk.service.AiTalkService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class AiTalkController {
	private final AiTalkService talkService;

	@PostMapping("/start")
	public ResponseEntity<AiTalkResponse> createChat(
		@RequestBody @Valid AiTalkSituationRequest aiTalkSituationRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(talkService.setSituation(aiTalkSituationRequest));
	}

	@Operation(summary = "AI 회화 메세지 전송")
	@PostMapping
	public ResponseEntity<?> sendMessage(@Valid @RequestBody AiTalkRequest aiTalkRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(talkService.getAIResponse(aiTalkRequest));
	}

	@Operation(summary = "AI 회화 끝내기")
	@GetMapping("/finish")
	public ResponseEntity<?> closeChat() {
		return ResponseEntity.status(HttpStatus.OK).body(talkService.finishAIResponse());
	}
}
