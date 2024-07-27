package com.ssafy.domain.review.service;

import com.ssafy.domain.review.model.dto.request.ReviewSaveRequest;

public interface ReviewService {

	void createReviewSentence(ReviewSaveRequest reviewSaveRequest);

	void deleteReviewSentence(Long reviewSentenceId);

}
