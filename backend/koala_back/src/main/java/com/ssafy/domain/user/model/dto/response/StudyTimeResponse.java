package com.ssafy.domain.user.model.dto.response;

import static lombok.AccessLevel.*;

import com.ssafy.domain.user.model.entity.StudyTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class StudyTimeResponse {

	private Integer timeCalType;
	private Long userId;
	private Integer talkTime;
	private Integer sentenceNum;
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
