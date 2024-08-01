package com.ssafy.domain.lecture.chat;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
@Component
@Slf4j
@Getter
public class LectureChatRoomManager {

    private ConcurrentHashMap<Long, LectureChatRoom> roomSessions = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> sessionToRoom = new ConcurrentHashMap<>();
}
