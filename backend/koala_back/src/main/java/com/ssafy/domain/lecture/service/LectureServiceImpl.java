package com.ssafy.domain.lecture.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ssafy.domain.lecture.model.dto.response.LectureResponse;
import com.ssafy.domain.lecture.model.entity.Lecture;
import com.ssafy.domain.lecture.repository.LectureRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
	private final LectureRepository lectureRepository;

	@Override
	public List<LectureResponse> getAllLectures() {
		List<Lecture> lectures = lectureRepository.findAll();
		return lectures.stream().map(LectureResponse::toDto).collect(Collectors.toList());
	}

	@Override
	public void writeLectureNote(Long lectureId) {

	}
}
