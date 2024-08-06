package com.ssafy.domain.user.service;

public interface StudyTimeService {

	void initStudyTime(Long userId);

	void increaseDictationCount(Integer DictationCount);

	void increaseLectureCount();

	void increaseTotalStudyTime(Long userId, Integer timeCalType, Integer studyTime);

}
