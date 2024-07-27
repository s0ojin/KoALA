package com.ssafy.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.sentence.model.entity.ReviewSentence;

public interface ReviewRepository extends JpaRepository<ReviewSentence, Long> {
}
