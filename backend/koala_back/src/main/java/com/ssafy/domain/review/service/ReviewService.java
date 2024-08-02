package com.ssafy.domain.review.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ssafy.domain.review.model.dto.request.ReviewSaveRequest;
import com.ssafy.domain.review.model.entity.ReviewSentence;

public interface ReviewService {

	Page<ReviewSentence> getReviewSentencesByUserAndKeyword(String keyword, Pageable pageable);

	void createReviewSentence(ReviewSaveRequest reviewSaveRequest);

	void deleteReviewSentence(Long reviewSentenceId);

}
