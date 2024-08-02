package com.ssafy.domain.review.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ssafy.domain.review.model.entity.ReviewSentence;
import com.ssafy.domain.user.model.entity.User;

public interface ReviewRepository extends JpaRepository<ReviewSentence, Long> {

	@Query("select rs from ReviewSentence rs where rs.user = :user and rs.sentence.sentenceText like %:keyword%")
	Page<ReviewSentence> findAllByUserAndSentenceContentContaining(@Param("user") User user,
		@Param("keyword") String keyword, Pageable pageable);

}
