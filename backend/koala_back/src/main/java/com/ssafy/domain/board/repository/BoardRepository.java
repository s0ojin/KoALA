package com.ssafy.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.domain.board.model.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	// Board의 CommentNUm을 1 증가시키는 메소드
	void increaseCommentNum(Long boardId);

}
