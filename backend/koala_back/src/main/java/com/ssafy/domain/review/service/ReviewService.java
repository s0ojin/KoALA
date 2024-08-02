package com.ssafy.domain.review.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ssafy.domain.review.model.dto.request.ReviewSaveRequest;
import com.ssafy.domain.review.model.dto.response.ReviewSentenceResponse;

public interface ReviewService {

	Page<ReviewSentenceResponse> getReviewSentencesByUserAndKeyword(String keyword, Pageable pageable);

	ReviewSentenceResponse createReviewSentence(ReviewSaveRequest reviewSaveRequest);

	void deleteReviewSentence(Long reviewSentenceId);

}
