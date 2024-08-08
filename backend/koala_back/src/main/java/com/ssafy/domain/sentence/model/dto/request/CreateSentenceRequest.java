package com.ssafy.domain.sentence.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateSentenceRequest {

	@JsonProperty("sentence_text")
	@NotBlank(message = "문장은 필수 입력 값입니다.")
	private String sentenceText;

}
