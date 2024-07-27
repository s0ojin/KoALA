package com.ssafy.domain.review.service;

import com.ssafy.domain.review.model.dto.request.ReviewSaveRequest;

public interface ReviewService {

    public void createReviewSentence(ReviewSaveRequest reviewSaveRequest);

    public void deleteReviewSentence(Long reviewSentenceId);

}
