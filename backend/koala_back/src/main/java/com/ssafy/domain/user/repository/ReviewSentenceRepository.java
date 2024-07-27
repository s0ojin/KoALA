package com.ssafy.domain.user.repository;

import com.ssafy.domain.sentence.model.entity.ReviewSentence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewSentenceRepository extends JpaRepository<ReviewSentence, Long> {
}
