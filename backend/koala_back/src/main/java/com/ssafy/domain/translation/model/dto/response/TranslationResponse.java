package com.ssafy.domain.translation.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TranslationResponse {
	@JsonProperty("translation_sentence")
	String translationSentence;
}
