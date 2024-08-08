package com.ssafy.domain.user.model.dto.response;

import com.ssafy.domain.user.model.entity.StudyTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudyTimeByDayResponse {

	private StudyTimeResponse mon;
	private StudyTimeResponse tue;
	private StudyTimeResponse wed;
	private StudyTimeResponse thu;
	private StudyTimeResponse fri;
	private StudyTimeResponse sat;
	private StudyTimeResponse sun;

	public static StudyTimeByDayResponse toDto(StudyTime mon, StudyTime tue, StudyTime wed, StudyTime thu,
		StudyTime fri, StudyTime sat, StudyTime sun) {
		return StudyTimeByDayResponse.builder()
			.mon(StudyTimeResponse.toDto(mon))
			.tue(StudyTimeResponse.toDto(tue))
			.wed(StudyTimeResponse.toDto(wed))
			.thu(StudyTimeResponse.toDto(thu))
			.fri(StudyTimeResponse.toDto(fri))
			.sat(StudyTimeResponse.toDto(sat))
			.sun(StudyTimeResponse.toDto(sun))
			.build();
	}
}
