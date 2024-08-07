package com.ssafy.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.user.model.entity.AiTalkLog;

public interface AiTalkLogRepository extends JpaRepository<AiTalkLog, Long> {

	AiTalkLog findByUserId(Long userId);

}
