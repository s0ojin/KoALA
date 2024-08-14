package com.ssafy.domain.lecture.repository;

import com.ssafy.domain.lecture.model.entity.LectureSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureScheduleRepository extends JpaRepository<LectureSchedule, Long> {

}
