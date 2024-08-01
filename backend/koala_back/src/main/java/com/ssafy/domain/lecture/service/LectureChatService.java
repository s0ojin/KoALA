package com.ssafy.domain.lecture.service;

import com.ssafy.domain.lecture.chat.LectureChatRoom;
import com.ssafy.domain.lecture.chat.LectureChatRoomManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureChatService {
    private final LectureChatRoomManager lectureChatRoomManager;
    public LectureChatRoom makeLectureChatRoom(Long lectureId){
        LectureChatRoom chatRoom = LectureChatRoom.builder()
                .lectureId(lectureId)
                .build();
        lectureChatRoomManager.getRoomSessions().put(lectureId, chatRoom);
        return chatRoom;
    }

    public void deleteLectureChatRoom(Long lectureId){
        lectureChatRoomManager.getRoomSessions().remove(lectureId);
    }

}
