package com.ssafy.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.board.model.entity.BoardComment;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {

}
