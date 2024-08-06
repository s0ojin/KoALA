package com.ssafy.domain.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.lecture.model.entity.LectureNote;

public interface LectureNoteRepository extends JpaRepository<LectureNote, Long> {
}
