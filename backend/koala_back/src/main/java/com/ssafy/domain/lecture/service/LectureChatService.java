package com.ssafy.domain.lecture.service;

import com.ssafy.domain.lecture.chat.LectureChatRoom;

public interface LectureChatService {
	public LectureChatRoom makeLectureChatRoom(Long lectureId);

	public void deleteLectureChatRoom(Long lectureId);
}
