package com.ssafy.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.domain.user.model.dto.response.StudyTimeResponse;
import com.ssafy.domain.user.model.dto.response.TotalStudyTimeResponse;
import com.ssafy.domain.user.model.entity.StudyTime;
import com.ssafy.domain.user.repository.StudyTimeRepository;
import com.ssafy.global.common.UserInfoProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudyTimeServiceImpl implements StudyTimeService {

	private final UserInfoProvider userInfoProvider;
	private final StudyTimeRepository studyTimeRepository;
	private final AiTalkLogService aiTalkLogService;

	@Override
	public TotalStudyTimeResponse getStudyTime() {
		Long userId = userInfoProvider.getCurrentUserId();
		StudyTime lastWeek = studyTimeRepository.findByUserIdAndTimeCalType(userId, 0);
		StudyTime thisWeek = studyTimeRepository.findByUserIdAndTimeCalType(userId, 1);
		StudyTime total = studyTimeRepository.findByUserIdAndTimeCalType(userId, 2);
		return TotalStudyTimeResponse.builder()
			.lastWeek(StudyTimeResponse.toDto(lastWeek))
			.thisWeek(StudyTimeResponse.toDto(thisWeek))
			.total(StudyTimeResponse.toDto(total))
			.build();
	}


	@Override
	@Transactional
	public void initStudyTime(Long userId) {
		/*지난주(0)/이번 주(1)/총 시간(2)
		이번 주
		월(3)/화(4)/수(5)/목(6)/금(7)/토(8)/일(9)
		지난주
		월(10)/화(11)/수(12)/목(13)/금(14)/토(15)/일(16)*/

		for (int i = 0; i < 17; i++) {
			StudyTime studyTime = StudyTime.builder()
				.timeCalType(i)
				.userId(userId)
				.talkTime(0)
				.sentenceNum(0)
				.lectureNum(0)
				.build();
			studyTimeRepository.save(studyTime);
		}
	}

	@Override
	@Transactional
	public void increaseDictationCount(Integer dictationCount) {
		Long userId = userInfoProvider.getCurrentUserId();
		StudyTime studyTime = studyTimeRepository.findByUserIdAndTimeCalType(userId, 1);
		studyTime.increaseSentenceNum(dictationCount);
		studyTimeRepository.save(studyTime);

		increaseTotalStudyTime(userId, 1, dictationCount);
	}

	@Override
	@Transactional
	public void increaseLectureCount() {
		Long userId = userInfoProvider.getCurrentUserId();
		StudyTime studyTime = studyTimeRepository.findByUserIdAndTimeCalType(userId, 1);
		studyTime.increaseLectureNum();
		studyTimeRepository.save(studyTime);

		increaseTotalStudyTime(userId, 2, 1);
	}

	@Override
	@Transactional
	public void increaseAiTalkMinutes() {
		Long userId = userInfoProvider.getCurrentUserId();
		StudyTime studyTime = studyTimeRepository.findByUserIdAndTimeCalType(userId, 1);
		Integer talkMinutes = aiTalkLogService.calculateTalkTime(userId);
		studyTime.increaseTalkTime(talkMinutes);
		studyTimeRepository.save(studyTime);

		increaseTotalStudyTime(userId, 0, talkMinutes);
	}


	@Override
	@Transactional
	public void increaseTotalStudyTime(Long userId, Integer studyType, Integer studyTime) {
		StudyTime userStudyTime = studyTimeRepository.findByUserIdAndTimeCalType(userId, 2);
		switch (studyType) {
			case 0: // AI 회화
				userStudyTime.increaseTalkTime(studyTime);
				break;
			case 1: // 받아쓰기
				userStudyTime.increaseSentenceNum(studyTime);
				break;
			case 2: // 강의 수
				userStudyTime.increaseLectureNum();
				break;
		}
		studyTimeRepository.save(userStudyTime);
	}

}
