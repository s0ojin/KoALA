package com.ssafy.domain.lecture.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.lecture.chat.LectureChatRoom;
import com.ssafy.domain.lecture.service.LectureChatService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures/chat")
public class LectureChatController {

	private final LectureChatService lectureChatService;

	@Operation(summary = "강의 채팅방 생성")
	@PostMapping
	public ResponseEntity<?> createRoom(@RequestParam(name = "lecture") Long lectureId) {
		LectureChatRoom chatRoom = lectureChatService.makeLectureChatRoom(lectureId);
		if (chatRoom == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Successfully created chat room"));
		}
	}

	@Operation(summary = "강의 채팅방 삭제")
	@DeleteMapping
	public ResponseEntity<?> deleteRoom(@RequestParam(name = "lecture") Long lectureId) {
		lectureChatService.deleteLectureChatRoom(lectureId);
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Successfully deleted chat room"));
	}

}
