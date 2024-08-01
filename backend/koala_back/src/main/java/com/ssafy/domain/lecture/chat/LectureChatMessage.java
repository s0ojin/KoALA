package com.ssafy.domain.lecture.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LectureChatMessage {
    private String messageType; // ENTER (들어왔을 경우), NOTICE (공지글), TALK (일반 채팅)
    private Long lectureId;
    private String sender;
//    private String receiver;
    private String message;
}
