package com.ssafy.domain.lecture.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.lecture.model.entity.RegisteredLecture;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisteredLectureResponse {
	@JsonProperty("lecture_id")
	private Long lectureId;

	@JsonProperty("teacher_name")
	private String teacherName;

	@JsonProperty("lecture_title")
	private String lectureTitle;

	public static RegisteredLectureResponse toDto(RegisteredLecture lecture) {
		return RegisteredLectureResponse.builder()
			.lectureId(lecture.getLecture().getLectureId())
			.teacherName(lecture.getLecture().getTeacher().getUsername())
			.lectureTitle(lecture.getLecture().getLectureTitle())
			.build();
	}
}
