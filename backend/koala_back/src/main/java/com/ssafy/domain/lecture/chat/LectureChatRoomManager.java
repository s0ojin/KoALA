package com.ssafy.domain.lecture.chat;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Component
@Getter
public class LectureChatRoomManager {

	private ConcurrentHashMap<Long, LectureChatRoom> roomSessions = new ConcurrentHashMap<>();

	private ConcurrentHashMap<String, Long> sessionToRoom = new ConcurrentHashMap<>();

}
