package com.ssafy.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.user.model.entity.StudyTime;
import com.ssafy.domain.user.model.entity.StudyTimeId;

public interface StudyTimeRepository extends JpaRepository<StudyTime, StudyTimeId> {

	StudyTime findByUserIdAndTimeCalType(Long userId, Integer timeCalType);

}
