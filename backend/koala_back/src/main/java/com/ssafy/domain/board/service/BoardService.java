package com.ssafy.domain.board.service;

import com.ssafy.domain.board.model.dto.request.BoardCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardResponse;

public interface BoardService {

	BoardResponse createBoard(BoardCreateRequest boardCreateRequest);
}
