package com.ssafy.domain.user.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.user.model.entity.StudyTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudyTimeResponse {

	@JsonProperty("time_cal_type")
	private Integer timeCalType;

	@JsonProperty("user_id")
	private Long userId;

	@JsonProperty("speaking")
	private Integer talkTime;

	@JsonProperty("writing")
	private Integer sentenceNum;

	@JsonProperty("lectures")
	private Integer lectureNum;

	public static StudyTimeResponse toDto(StudyTime studyTime) {
		return StudyTimeResponse.builder()
			.timeCalType(studyTime.getTimeCalType())
			.userId(studyTime.getUserId())
			.talkTime(studyTime.getTalkTime())
			.sentenceNum(studyTime.getSentenceNum())
			.lectureNum(studyTime.getLectureNum())
			.build();
	}
}
