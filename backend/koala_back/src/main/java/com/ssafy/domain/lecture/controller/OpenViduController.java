package com.ssafy.domain.lecture.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.openvidu.java.client.Connection;
import io.openvidu.java.client.ConnectionProperties;
import io.openvidu.java.client.OpenVidu;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;
import io.openvidu.java.client.Session;
import io.openvidu.java.client.SessionProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures/openvidu")
public class OpenViduController {

	private final OpenVidu openvidu;

	@PostMapping("/sessions")
	public ResponseEntity<?> initializeSession(@RequestBody(required = false) Map<String, Object> params) {
		try {
			SessionProperties properties = SessionProperties.fromJson(params).build();
			Session session = openvidu.createSession(properties);
			JSONObject response = new JSONObject();
			response.put("sessionId", session.getSessionId());
			return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
		} catch (OpenViduJavaClientException | OpenViduHttpException e) {
			log.error("Error creating session", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new JSONObject().put("message", "Error creating session").toString());
		}
	}

	@PostMapping("/sessions/{sessionId}/connections")
	public ResponseEntity<?> createConnection(@PathVariable("sessionId") String sessionId,
		@RequestBody(required = false) Map<String, Object> params) {
		try {
			Session session = openvidu.getActiveSession(sessionId);
			if (session == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new JSONObject().put("message", "Session not found").toString());
			}
			ConnectionProperties properties = ConnectionProperties.fromJson(params).build();
			Connection connection = session.createConnection(properties);
			JSONObject response = new JSONObject();
			response.put("token", connection.getToken());
			return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
		} catch (OpenViduJavaClientException | OpenViduHttpException e) {
			log.error("Error creating connection", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new JSONObject().put("message", "Error creating connection").toString());
		}
	}
}
