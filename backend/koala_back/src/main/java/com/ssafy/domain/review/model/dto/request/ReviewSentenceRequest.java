package com.ssafy.domain.review.model.dto.request;

import static lombok.AccessLevel.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.review.model.entity.ReviewSentence;
import com.ssafy.domain.sentence.model.entity.Sentence;
import com.ssafy.domain.user.model.entity.User;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class ReviewSentenceRequest {

	@NotBlank(message = "문장 ID는 필수 입력 값입니다.")
	@JsonProperty("sentence_id")
	private Long sentenceId;

	public ReviewSentence toEntity(Sentence sentence, User user) {
		return ReviewSentence.builder().sentence(sentence).user(user).build();
	}
}