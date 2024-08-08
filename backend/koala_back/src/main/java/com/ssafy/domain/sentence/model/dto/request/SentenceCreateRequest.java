package com.ssafy.domain.sentence.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.sentence.model.entity.Sentence;
import com.ssafy.domain.user.model.entity.User;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SentenceCreateRequest {

	@JsonProperty("sentence_text")
	@NotBlank(message = "문장은 필수 입력 값입니다.")
	private String sentenceText;

	public Sentence toEntity(User user) {
		return Sentence.builder()
			.sentenceText(sentenceText)
			.topicCategory("사용자")
			.sentenceLength(sentenceText.length())
			.user(user)
			.build();
	}

}
