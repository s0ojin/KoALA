package com.ssafy.domain.lecture.model.dto.request;

import java.util.Date;

import com.ssafy.domain.lecture.model.entity.Lecture;
import com.ssafy.domain.lecture.model.entity.LectureNote;
import com.ssafy.domain.user.model.entity.Auth;
import com.ssafy.domain.user.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LectureNoteRequest {
	Long lectureId;
	String noteTitle;
	String noteContent;

	public LectureNote toEntity(User user, Lecture lecture) {
		return LectureNote.builder()
			.user(user)
			.lecture(lecture)
			.noteTitle(noteTitle)
			.noteContent(noteContent)
			.build();
	}
}
