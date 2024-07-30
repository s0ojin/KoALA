package com.ssafy.domain.board.controller;

import org.json.JSONObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.board.model.dto.request.BoardCommentCreateRequest;
import com.ssafy.domain.board.model.dto.request.BoardCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardCommentResponse;
import com.ssafy.domain.board.model.dto.response.BoardResponse;
import com.ssafy.domain.board.model.dto.response.BoardDetailResponse;
import com.ssafy.domain.board.service.BoardCommentService;
import com.ssafy.domain.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

	private final BoardService boardService;
	private final BoardCommentService boardCommentService;

	@PostMapping
	public ResponseEntity<?> createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
		BoardResponse boardCreateResponse = boardService.createBoard(boardCreateRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(boardCreateResponse);
	}

	@GetMapping
	public ResponseEntity<?> getBoards(Pageable pageable) {
		return ResponseEntity.ok().body(boardService.getBoards(pageable));
	}

	@GetMapping("/sorted-by-hit")
	public ResponseEntity<?> getBoardsSortedByHit(Pageable pageable) {
		return ResponseEntity.ok().body(boardService.getBoardsSortedByHit(pageable));
	}


	@GetMapping("/{board_id}/comments")
	public ResponseEntity<?> getBoard(@PathVariable("board_id") Long boardId, Pageable pageable) {
		BoardDetailResponse boardDetailResponse = boardService.getBoard(boardId, pageable);
		boardService.increaseHit(boardId);
		return ResponseEntity.ok().body(boardDetailResponse);
	}

	@DeleteMapping("/{board_id}")
	public ResponseEntity<?> deleteBoard(@PathVariable("board_id") Long boardId) {
		boardService.deleteBoard(boardId);
		return ResponseEntity.ok(new JSONObject().put("message", "게시글 삭제 성공!").toString());
	}

	@PostMapping("/{board_id}/comments")
	public ResponseEntity<?> createComment(@PathVariable("board_id") Long boardId,
		@RequestBody BoardCommentCreateRequest boardCommentCreateRequest) {
		BoardCommentResponse boardCommentResponse = boardCommentService.createComment(boardId,
			boardCommentCreateRequest);
		boardService.increaseCommentNum(boardId);
		return ResponseEntity.status(HttpStatus.CREATED).body(boardCommentResponse);
	}

	@DeleteMapping("/comments/{comment_id}")
	public ResponseEntity<?> deleteComment(@PathVariable("comment_id") Long commentId) {
		boardCommentService.deleteComment(commentId);
		return ResponseEntity.ok(new JSONObject().put("message", "댓글 삭제 성공!").toString());
	}

}
