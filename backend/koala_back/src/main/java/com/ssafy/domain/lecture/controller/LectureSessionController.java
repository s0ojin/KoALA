package com.ssafy.domain.lecture.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.lecture.model.dto.response.RegisteredLectureResponse;
import com.ssafy.domain.lecture.service.LectureService;

import io.openvidu.java.client.Connection;
import io.openvidu.java.client.ConnectionProperties;
import io.openvidu.java.client.OpenVidu;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;
import io.openvidu.java.client.Session;
import io.openvidu.java.client.SessionProperties;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/lectures")
public class LectureSessionController {

	private final OpenVidu openvidu;
	private final LectureService lectureService;

	@Operation(summary = "강의 session 생성")
	@PostMapping("/{lecture_id}/session")
	public ResponseEntity<?> initializeSession(@PathVariable("lecture_id") Long lectureId,
		@RequestBody(required = false) Map<String, Object> params) {
		try {
			SessionProperties properties = SessionProperties.fromJson(params).build();
			Session session = openvidu.createSession(properties);
			// 해당 강의에 세션 아이디 추가
			lectureService.setSessionId(lectureId, session.getSessionId());
			// 수강하는 강의에 추가: 강의 노트 추가할 때 추가하고 싶으면 lecture controller 이동
			RegisteredLectureResponse registeredLecture = lectureService.registerLecture(lectureId);
			return ResponseEntity.status(HttpStatus.CREATED)
				.body(Map.of("session_id", session.getSessionId(), "lecture_id", registeredLecture.getLectureId()));
		} catch (OpenViduJavaClientException | OpenViduHttpException e) {
			log.error("Error creating session", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Map.of("message", "Error creating session"));
		}
	}

	@Operation(summary = "강의 {lecture_id}에 연결")
	@PostMapping("/{lecture_id}/connections")
	public ResponseEntity<?> createConnection(@PathVariable("lecture_id") Long lectureId,
		@RequestBody(required = false) Map<String, Object> params) {
		try {
			String sessionId = lectureService.getSessionId(lectureId);
			if (sessionId == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Lecture not found"));
			}
			Session session = openvidu.getActiveSession(sessionId);
			if (session == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Session not found"));
			}
			ConnectionProperties properties = ConnectionProperties.fromJson(params).build();
			Connection connection = session.createConnection(properties);
			// lectureService.registerd
			return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("token", connection.getToken()));
		} catch (OpenViduJavaClientException | OpenViduHttpException e) {
			log.error("Error creating connection", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Map.of("message", "Error creating connection"));
		}
	}
}
