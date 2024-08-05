package com.ssafy.domain.lecture.model.dto.response;

import java.time.LocalDateTime;

import com.ssafy.domain.lecture.model.entity.LectureNote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LectureNoteResponse {
	private Long noteId;
	private String noteTitle;
	private String noteContent;
	private LocalDateTime noteCreatedAt;

	public static LectureNoteResponse toDto(LectureNote lectureNote) {
		return LectureNoteResponse.builder()
			.noteId(lectureNote.getNoteId())
			.noteTitle(lectureNote.getNoteTitle())
			.noteContent(lectureNote.getNoteContent())
			.noteCreatedAt(lectureNote.getNoteCreatedAt())
			.build();
	}
}
