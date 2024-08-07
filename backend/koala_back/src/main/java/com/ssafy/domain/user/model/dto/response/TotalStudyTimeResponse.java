package com.ssafy.domain.user.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TotalStudyTimeResponse {

	@JsonProperty("last_week")
	StudyTimeResponse lastWeek;

	@JsonProperty("this_week")
	StudyTimeResponse thisWeek;

	@JsonProperty("total")
	StudyTimeResponse total;
}
