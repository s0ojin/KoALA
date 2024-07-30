package com.ssafy.domain.board.service;

import org.springframework.data.domain.Pageable;

import com.ssafy.domain.board.model.dto.request.BoardCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardResponse;
import com.ssafy.domain.board.model.dto.response.BoardDetailResponse;

public interface BoardService {

	BoardDetailResponse getBoard(Long boardId, Pageable pageable);

	BoardResponse createBoard(BoardCreateRequest boardCreateRequest);

	void increaseCommentNum(Long boardId);

	void increaseHit(Long boardId);
}
