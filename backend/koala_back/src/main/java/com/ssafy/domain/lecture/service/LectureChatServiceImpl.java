package com.ssafy.domain.lecture.service;

import org.springframework.stereotype.Service;

import com.ssafy.domain.lecture.chat.LectureChatRoom;
import com.ssafy.domain.lecture.chat.LectureChatRoomManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureChatServiceImpl implements LectureChatService {
	private final LectureChatRoomManager lectureChatRoomManager;

	@Override
	public LectureChatRoom makeLectureChatRoom(Long lectureId) {
		LectureChatRoom chatRoom = LectureChatRoom.builder().lectureId(lectureId).build();
		lectureChatRoomManager.getRoomSessions().put(lectureId, chatRoom);
		return chatRoom;
	}

	@Override
	public void deleteLectureChatRoom(Long lectureId) {
		lectureChatRoomManager.getRoomSessions().remove(lectureId);
	}

}
