package com.ssafy.domain.lecture.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.lecture.model.dto.request.LectureNoteRequest;
import com.ssafy.domain.lecture.model.dto.response.LectureResponse;
import com.ssafy.domain.lecture.service.LectureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LectureController {
	private final LectureService lectureService;

	@GetMapping
	public ResponseEntity<?> getAllLectures() {
		List<LectureResponse> lectures = lectureService.getAllLectures();
		if (lectures.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(lectures);
		}
	}

	@PostMapping("/{lectureId}/note")
	public ResponseEntity<?> createLectureNote(@PathVariable String lectureId,
		@RequestBody LectureNoteRequest lectureNoteRequest) {



		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}

}
