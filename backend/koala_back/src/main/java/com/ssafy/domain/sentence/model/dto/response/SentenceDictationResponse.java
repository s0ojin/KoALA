package com.ssafy.domain.sentence.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.sentence.model.entity.Sentence;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SentenceDictationResponse {

	@JsonProperty("sentence_id")
	Long sentenceId;

	@JsonProperty("sentence_text")
	String sentenceText;

	@JsonProperty("sentence_length")
	Integer sentenceLength;

	public static SentenceDictationResponse toDto(Sentence sentence) {
		return SentenceDictationResponse.builder()
			.sentenceId(sentence.getSentenceId())
			.sentenceText(sentence.getSentenceText())
			.sentenceLength(sentence.getSentenceLength())
			.build();
	}
}
