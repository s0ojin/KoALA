package com.ssafy.domain.lecture.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.domain.lecture.chat.LectureChatRoom;
import com.ssafy.domain.lecture.chat.LectureChatRoomManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LectureChatServiceImpl implements LectureChatService {

	private final LectureChatRoomManager lectureChatRoomManager;

	@Override
	@Transactional
	public LectureChatRoom makeLectureChatRoom(Long lectureId) {
		LectureChatRoom chatRoom = LectureChatRoom.builder().lectureId(lectureId).build();
		lectureChatRoomManager.getRoomSessions().put(lectureId, chatRoom);
		return chatRoom;
	}

	@Override
	@Transactional
	public void deleteLectureChatRoom(Long lectureId) {
		lectureChatRoomManager.getRoomSessions().remove(lectureId);
	}

}
