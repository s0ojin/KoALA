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

	@JsonProperty("talk_time")
	private Integer talkTime;

	@JsonProperty("sentence_num")
	private Integer sentenceNum;

	@JsonProperty("lecture_num")
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
