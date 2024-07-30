package com.ssafy.domain.board.service;

import com.ssafy.domain.board.model.dto.request.BoardCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardResponse;

public interface BoardService {

	BoardResponse getBoard(Long boardId);

	BoardResponse createBoard(BoardCreateRequest boardCreateRequest);

	void increaseCommentNum(Long boardId);
}
