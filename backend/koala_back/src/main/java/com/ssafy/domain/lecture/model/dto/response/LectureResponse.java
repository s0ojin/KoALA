package com.ssafy.domain.lecture.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.lecture.model.entity.Lecture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class LectureResponse {

	@JsonProperty("lecture_id")
	private Long lectureId;

	@JsonProperty("teacher_name")
	private String teacherName;

	@JsonProperty("lecture_title")
	private String lectureTitle;

	@JsonProperty("lecture_detail")
	private String lectureDetail;

	@JsonProperty("session_id")
	private String sessionId;

	public static LectureResponse toDto(Lecture lecture) {
		return LectureResponse.builder()
			.lectureId(lecture.getLectureId())
			.teacherName(lecture.getTeacher().getUsername())
			.lectureTitle(lecture.getLectureTitle())
			.lectureDetail(lecture.getLectureDetail())
			.sessionId(lecture.getSessionId())
			.build();
	}

}
