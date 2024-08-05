package com.ssafy.domain.lecture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ssafy.domain.lecture.model.entity.RegisteredLecture;
import com.ssafy.domain.lecture.model.entity.RegisteredLectureId;

public interface RegisteredLectureRepository extends JpaRepository<RegisteredLecture, RegisteredLectureId> {
	@Query(value = "SELECT * FROM registered_lecture WHERE user_id = :userId", nativeQuery = true)
	List<RegisteredLecture> findByUserId(@Param("userId") Long userId);
}
