package com.ssafy.domain.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.board.model.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Page<Board> findAllByOrderByHitDesc(Pageable pageable);
}
