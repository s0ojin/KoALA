package com.ssafy.domain.board.service;

import com.ssafy.domain.board.model.dto.request.BoardCommentCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardCommentResponse;

public interface BoardCommentService {

	BoardCommentResponse createComment(Long boardId, BoardCommentCreateRequest boardCommentCreateRequest);
}
