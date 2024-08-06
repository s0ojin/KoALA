package com.ssafy.domain.lecture.service;

import com.ssafy.domain.lecture.chat.LectureChatRoom;

public interface LectureChatService {

	LectureChatRoom makeLectureChatRoom(Long lectureId);

	void deleteLectureChatRoom(Long lectureId);

}
