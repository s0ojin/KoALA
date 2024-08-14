package com.ssafy.domain.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.lecture.model.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
