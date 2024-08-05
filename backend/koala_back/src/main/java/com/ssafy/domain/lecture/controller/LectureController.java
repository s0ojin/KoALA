package com.ssafy.domain.lecture.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.lecture.model.dto.request.LectureNoteRequest;
import com.ssafy.domain.lecture.model.dto.response.LectureNoteResponse;
import com.ssafy.domain.lecture.model.dto.response.LectureResponse;
import com.ssafy.domain.lecture.model.dto.response.RegisteredLectureResponse;
import com.ssafy.domain.lecture.repository.RegisteredLectureRepository;
import com.ssafy.domain.lecture.service.LectureService;
import com.ssafy.domain.sentence.service.SentenceService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
public class LectureController {
	private final LectureService lectureService;
	private final SentenceService sentenceService;
	private final RegisteredLectureRepository registeredLectureRepository;

	@Operation(summary = "모든 강의 조회")
	@GetMapping("/all")
	public ResponseEntity<?> getAllLecture() {
		List<LectureResponse> lectures = lectureService.getAllLecture();
		if (lectures.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(lectures);
		}
	}

	@Operation(summary = "수강한 강의 조회")
	@GetMapping
	public ResponseEntity<?> getAllRegisteredLecture() {
		List<RegisteredLectureResponse> lectureResponses = lectureService.getRegisteredLecture();
		if (lectureResponses.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(lectureResponses);
		}
	}

	@Operation(summary = "강의노트 등록")
	@PostMapping("/note")
	public ResponseEntity<?> createLectureNote(@RequestBody LectureNoteRequest lectureNoteRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(lectureService.writeLectureNote(lectureNoteRequest));
	}

	@Operation(summary = "강의 {lectureId}에 등록된 모든 강의노트 조회")
	@GetMapping("/{lecture_id}/note")
	public ResponseEntity<?> getLectureNote(@PathVariable("lecture_id") Long lectureId) {
		List<LectureNoteResponse> lectureNotes = lectureService.readLectureNote(lectureId);
		if (lectureNotes.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(lectureNotes);
		}
	}

	@Operation(summary = "강의노트 {noteId} 삭제")
	@DeleteMapping("/note/{note_id}")
	public ResponseEntity<?> deleteLectureNote(@PathVariable("note_id") Long noteId) {
		if (lectureService.deleteLectureNote(noteId))
			return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Delete successful"));
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Not found with id: " + noteId));
	}

	@Operation(summary = "강의 {lectureId}에서 제공하는 문장 조회")
	@GetMapping("/{lecture_id}/sentences")
	public ResponseEntity<?> getLectureSentences(@PathVariable("lecture_id") Long lectureId) {
		return ResponseEntity.status(HttpStatus.OK).body(sentenceService.getLectureSentences(lectureId));
	}
}
