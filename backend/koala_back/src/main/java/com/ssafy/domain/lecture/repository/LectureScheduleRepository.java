package com.ssafy.domain.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.lecture.model.entity.LectureSchedule;

public interface LectureScheduleRepository extends JpaRepository<LectureSchedule, Long> {
}
