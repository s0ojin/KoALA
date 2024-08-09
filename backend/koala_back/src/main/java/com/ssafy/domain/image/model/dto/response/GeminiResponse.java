package com.ssafy.domain.image.model.dto.response;

import static lombok.AccessLevel.*;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class GeminiResponse {

	private List<Candidate> candidates;

	@Getter
	public static class Candidate {
		private Content content;
		private String finishReason;
		private int index;
		List<SafetyRating> safetyRatings;
	}

	@Getter
	public static class Content {
		private List<TextPart> parts;
		private String role;
	}

	@Getter
	public static class TextPart {
		private String text;
	}

	@Getter
	public static class SafetyRating {
		private String category;
		private String probability;
	}
}
