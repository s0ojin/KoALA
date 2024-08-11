package com.ssafy.domain.lecture.repository;

import com.ssafy.domain.lecture.model.entity.LectureNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureNoteRepository extends JpaRepository<LectureNote, Long> {
    @Query(value = "SELECT * FROM lecture_notes WHERE user_id = :userId and lecture_id = :lectureId", nativeQuery = true)
    List<LectureNote> findByLectureId(@Param("userId") Long userId, @Param("lectureId") Long lectureId);

}
