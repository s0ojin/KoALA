package com.ssafy.domain.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.board.model.entity.BoardImage;

public interface BoardImageRepository extends JpaRepository<BoardImage, Long> {

	// BoardId로 BoardImages 조회
	List<BoardImage> findAllByBoardId(Long boardId);
}
