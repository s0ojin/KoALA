package com.ssafy.domain.review.repository;

import com.ssafy.domain.sentence.model.entity.ReviewSentence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewSentence, Long> {
}
