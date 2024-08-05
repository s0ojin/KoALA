package com.ssafy.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.domain.user.model.entity.StudyTime;
import com.ssafy.domain.user.repository.StudyTimeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudyTimeServiceImpl implements StudyTimeService {

	private final StudyTimeRepository studyTimeRepository;

	@Override
	@Transactional
	public void initStudyTime(Long userId) {
		for (int i = 0; i < 3; i++) {
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
	public void increaseDictationCount(Long userId, Integer dictationCount) {
		StudyTime studyTime = studyTimeRepository.findByUserIdAndTimeCalType(userId, 1);
		studyTime.increaseSentenceNum(dictationCount);
		studyTimeRepository.save(studyTime);
		increaseTotalStudyTime(userId, 1, dictationCount);
	}

	@Override
	@Transactional
	public void increaseTotalStudyTime(Long userId, Integer studyType, Integer studyTime) {
		switch (studyType) {
			case 0: // AI 회화
				StudyTime talkTime = studyTimeRepository.findByUserIdAndTimeCalType(userId, 2);
				talkTime.increaseTalkTime(studyTime);
				studyTimeRepository.save(talkTime);
				break;
			case 1: // 받아쓰기
				StudyTime sentenceNum = studyTimeRepository.findByUserIdAndTimeCalType(userId, 2);
				sentenceNum.increaseSentenceNum(studyTime);
				studyTimeRepository.save(sentenceNum);
				break;
			case 2: // 강의 수
				StudyTime lectureNum = studyTimeRepository.findByUserIdAndTimeCalType(userId, 2);
				lectureNum.increaseLectureNum(studyTime);
				studyTimeRepository.save(lectureNum);
				break;
		}
	}


}
