package com.ssafy.domain.sentence.model.dto.request;

import static lombok.AccessLevel.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
public class SentenceTestRequest {

	@NotNull(message = "문장 번호는 필수 입력 값입니다.")
	@JsonProperty("sentence_id")
	private Long sentenceId;

	@NotNull(message = "답안은 필수 입력 값입니다.")
	@JsonProperty("user_sentence")
	private String userSentence;

	@NotNull(message = "토글 여부는 필수 입력 값입니다.")
	@JsonProperty("is_toggled")
	private boolean isToggled;

}
