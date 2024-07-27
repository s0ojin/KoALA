package com.ssafy.domain.sentence.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SentenceTestRequest {

	@JsonProperty("sentence_id")
	private Long sentenceId;
	@JsonProperty("user_sentence")
	String userSentence;
	@JsonProperty("is_toggled")
	boolean isToggled;

}
