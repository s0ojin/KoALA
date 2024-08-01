package com.ssafy.domain.review.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.sentence.model.entity.ReviewSentence;
import com.ssafy.domain.sentence.model.entity.Sentence;
import com.ssafy.domain.user.model.entity.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewSaveRequest {

	@NotBlank(message = "리뷰 내용은 필수 입력 값입니다.")
	@JsonProperty("sentence_id")
	private Long sentenceId;

	public ReviewSentence toReviewSentenceEntity(Sentence sentence, User user) {
		return ReviewSentence.builder()
			.sentence(sentence)
			.user(user)
			.build();
	}

}
