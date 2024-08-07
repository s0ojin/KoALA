package com.ssafy.domain.user.service;

public interface AiTalkLogService {

	void initAiTalkLog(Long userId);

	void createStartTimeLog(Long userId);

	void createEndTimeLog(Long userId);

	Integer calculateTalkTime(Long userId);

}
