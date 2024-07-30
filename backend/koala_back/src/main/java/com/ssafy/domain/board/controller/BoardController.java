package com.ssafy.domain.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.board.model.dto.request.BoardCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardResponse;
import com.ssafy.domain.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

	private final BoardService boardService;

	@GetMapping("/{board_id}")
	public ResponseEntity<?> getBoard(@PathVariable("board_id") Long boardId) {
		BoardResponse boardResponse = boardService.getBoard(boardId);
		return ResponseEntity.ok().body(boardResponse);
	}

	@PostMapping
	public ResponseEntity<?> createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
		BoardResponse boardResponse = boardService.createBoard(boardCreateRequest);
		return ResponseEntity.ok().body(boardResponse);
	}

}
