package com.ssafy.domain.sentence.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateSentenceRequest {

	@NotBlank(message = "문장은 필수 입력 값입니다.")
	private String sentence;

}
