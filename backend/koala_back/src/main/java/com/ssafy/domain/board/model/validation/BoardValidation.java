package com.ssafy.domain.board.model.validation;

public class BoardValidation {

	private static final String KOREAN_NUMERIC_REGEX = "^[가-힣0-9]+$";

	public static void validateKoreanAndNumeric(String input) {
		if (!input.matches(KOREAN_NUMERIC_REGEX)) {
			throw new IllegalArgumentException("입력된 데이터에 한글과 숫자 이외의 문자가 포함되어 있습니다.");
		}
	}

}
