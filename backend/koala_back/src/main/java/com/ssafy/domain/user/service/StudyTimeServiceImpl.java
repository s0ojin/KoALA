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
}
