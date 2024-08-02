package com.ssafy.domain.lecture.service;

import java.util.List;

import com.ssafy.domain.lecture.model.dto.response.LectureResponse;

public interface LectureService {
	List<LectureResponse> getAllLectures();
	void writeLectureNote(Long lectureId);
}
