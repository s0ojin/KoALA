package com.ssafy.domain.review.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.review.model.dto.request.ReviewSaveRequest;
import com.ssafy.domain.review.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

	private final ReviewService reviewService;

	@Operation(summary = "복습문장 주제 및 키워드 조회")
	@GetMapping
	public ResponseEntity<?> getReviewSentencesByUserAndKeyword(
		@RequestParam(name = "keyword", required = false) String keyword,
		@RequestParam(name = "topic", required = false) String topic) {
		return ResponseEntity.ok().body(reviewService.getReviewSentencesByUserAndKeyword(keyword, topic));
	}

	@Operation(summary = "복습문장 저장")
	@PostMapping
	public ResponseEntity<?> createReviewSentence(@Valid @RequestBody ReviewSaveRequest reviewSaveRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReviewSentence(reviewSaveRequest));
	}

	@Operation(summary = "복습에 저장된 특정 문장 삭제")
	@DeleteMapping("/{review_sentence_id}")
	public ResponseEntity<?> deleteReviewSentence(@PathVariable("review_sentence_id") Long reviewSentenceId) {
		reviewService.deleteReviewSentence(reviewSentenceId);
		return ResponseEntity.ok().body("복습 문장을 삭제했습니다.");
	}

}