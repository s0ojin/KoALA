package com.ssafy.domain.review.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.review.model.dto.request.ReviewSaveRequest;
import com.ssafy.domain.review.service.ReviewService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

	private final ReviewService reviewService;

	@PostMapping
	public ResponseEntity<?> createReviewSentence(@Valid @RequestBody ReviewSaveRequest reviewSaveRequest) {
		reviewService.createReviewSentence(reviewSaveRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body("복습 문장을 추가했습니다.");
	}

	@DeleteMapping("/{review_sentence_id}")
	public ResponseEntity<?> deleteReviewSentence(@PathVariable("review_sentence_id") Long reviewSentenceId) {
		reviewService.deleteReviewSentence(reviewSentenceId);
		return ResponseEntity.ok().body("복습 문장을 삭제했습니다.");
	}

}
