package com.ssafy.domain.lecture.model.dto.response;

import com.ssafy.domain.lecture.model.entity.Lecture;
import com.ssafy.domain.user.model.dto.response.UserResponse;
import com.ssafy.domain.user.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureResponse {
	private Long lectureId;
	private Long teacherId;
	private String lectureTitle;
	private String lectureDetail;
	private String lectureUrl;
	private boolean isOpen;

	public static LectureResponse toDto(Lecture lecture) {
		return LectureResponse.builder()
			.lectureId(lecture.getLectureId())
			.teacherId(lecture.getTeacher().getUserId())
			.lectureTitle(lecture.getLectureTitle())
			.lectureDetail(lecture.getLectureDetail())
			.lectureUrl(lecture.getLectureUrl())
			.isOpen(lecture.getIsOpen() != 1)
			.build();
	}
}
