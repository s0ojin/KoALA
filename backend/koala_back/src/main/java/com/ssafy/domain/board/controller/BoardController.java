package com.ssafy.domain.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.domain.board.model.dto.request.BoardCommentCreateRequest;
import com.ssafy.domain.board.model.dto.request.BoardCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardCommentResponse;
import com.ssafy.domain.board.model.dto.response.BoardDetailResponse;
import com.ssafy.domain.board.model.validation.BoardValidation;
import com.ssafy.domain.board.service.BoardCommentService;
import com.ssafy.domain.board.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

	private final BoardService boardService;
	private final BoardCommentService boardCommentService;

	@Operation(summary = "게시글 작성")
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> createBoard(
		@Valid @RequestPart(value = "board_detail") BoardCreateRequest boardCreateRequest,
		@RequestPart(value = "board_images") List<MultipartFile> images) throws IOException {

		if (BoardValidation.validateKoreanAndNumeric(boardCreateRequest.getTitle())) {
			return ResponseEntity.badRequest()
				.body(Map.of("message", "게시글 제목은 한글과 숫자, 특수문자만 입력 가능합니다."));
		}
		if (BoardValidation.validateKoreanAndNumeric(boardCreateRequest.getContent())) {
			return ResponseEntity.badRequest()
				.body(Map.of("message", "게시글 내용은 한글과 숫자, 특수문자만 입력 가능합니다."));
		}

		// 추가: files 리스트를 boardCreateRequest에 설정
		boardCreateRequest.setBoardImages(images);

		BoardDetailResponse boardCreateResponse = boardService.createBoard(boardCreateRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(boardCreateResponse);
	}

	@Operation(summary = "게시글 목록 조회", description = "query parameter로 page, size 페이징 처리")
	@GetMapping
	public ResponseEntity<?> getBoards(Pageable pageable) {
		return ResponseEntity.ok().body(boardService.getBoards(pageable));
	}

	@Operation(summary = "게시글 상세 조회", description = "게시글 조회 시 조회수 증가")
	@GetMapping("/{board_id}/comments")
	public ResponseEntity<?> getBoard(@PathVariable("board_id") Long boardId, Pageable pageable) {
		BoardDetailResponse boardDetailResponse = boardService.getBoard(boardId, pageable);
		boardService.increaseHit(boardId);
		return ResponseEntity.ok().body(boardDetailResponse);
	}

	@Operation(summary = "게시글 조회수 순 정렬 목록 조회", description = "query parameter로 page, size 페이징 처리")
	@GetMapping("/sorted-by-hit")
	public ResponseEntity<?> getBoardsSortedByHit(Pageable pageable) {
		return ResponseEntity.ok().body(boardService.getBoardsSortedByHit(pageable));
	}

	@Operation(summary = "게시글 키워드 조회", description = "query parameter로 keyword 검색 및 page, size 페이징 처리")
	@GetMapping("/search")
	public ResponseEntity<?> getBoardsByKeyword(@RequestParam("keyword") String keyword, Pageable pageable) {
		return ResponseEntity.ok().body(boardService.getBoardsByKeyword(keyword, pageable));
	}

	@Operation(summary = "내가 작성한 게시글 목록 조회", description = "query parameter로 page, size 페이징 처리")
	@GetMapping("/my-content")
	public ResponseEntity<?> getBoardsByUser(Pageable pageable) {
		return ResponseEntity.ok().body(boardService.getBoardsByUser(pageable));
	}

	@Operation(summary = "게시글 삭제")
	@DeleteMapping("/{board_id}")
	public ResponseEntity<?> deleteBoard(@PathVariable("board_id") Long boardId) {
		boardService.deleteBoard(boardId);
		return ResponseEntity.ok().body(Map.of("message", "게시글 삭제 성공!"));
	}

	@Operation(summary = "게시글 댓글 작성")
	@PostMapping("/{board_id}/comments")
	public ResponseEntity<?> createComment(@PathVariable("board_id") Long boardId,
		@Valid @RequestBody BoardCommentCreateRequest boardCommentCreateRequest) {
		if (BoardValidation.validateKoreanAndNumeric(boardCommentCreateRequest.getCommentContent())) {
			return ResponseEntity.badRequest()
				.body(Map.of("message", "댓글 내용은 한글과 숫자, 특수문자만 입력 가능합니다."));
		}
		BoardCommentResponse boardCommentResponse = boardCommentService.createComment(boardId,
			boardCommentCreateRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(boardCommentResponse);
	}

	@Operation(summary = "게시글 댓글 삭제")
	@DeleteMapping("/comments/{comment_id}")
	public ResponseEntity<?> deleteComment(@PathVariable("comment_id") Long commentId) {
		boardCommentService.deleteComment(commentId);
		return ResponseEntity.ok().body(Map.of("message", "댓글 삭제 성공!"));
	}

}
