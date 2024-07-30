package com.ssafy.domain.board.service;

import org.springframework.data.domain.Pageable;

import com.ssafy.domain.board.model.dto.request.BoardCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardCreateResponse;
import com.ssafy.domain.board.model.dto.response.BoardResponse;

public interface BoardService {

	BoardResponse getBoard(Long boardId, Pageable pageable);

	BoardCreateResponse createBoard(BoardCreateRequest boardCreateRequest);

	void increaseCommentNum(Long boardId);

	void increaseHit(Long boardId);
}
