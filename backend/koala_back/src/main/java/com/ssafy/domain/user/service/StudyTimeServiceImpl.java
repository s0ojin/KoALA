package com.ssafy.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudyTimeServiceImpl implements StudyTimeService {

	@Override
	public void initStudyTime(Long userId) {
		// TODO Auto-generated method stub
	}
}
