package com.ssafy.domain.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.domain.board.model.dto.request.BoardCommentCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardCommentResponse;
import com.ssafy.domain.board.model.entity.Board;
import com.ssafy.domain.board.repository.BoardCommentRepository;
import com.ssafy.domain.board.repository.BoardRepository;
import com.ssafy.global.common.UserInfoProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardCommentServiceImpl implements BoardCommentService {

	private final UserInfoProvider userInfoProvider;
	private final BoardRepository boardRepository;
	private final BoardCommentRepository boardCommentRepository;

	@Override
	@Transactional
	public BoardCommentResponse createComment(Long boardId, BoardCommentCreateRequest boardCommentCreateRequest) {
		Board currentBoard = boardRepository.findById(boardId)
			.orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
		return BoardCommentResponse.toDto(boardCommentRepository.save(
			boardCommentCreateRequest.toEntity(userInfoProvider.getCurrentUser(), currentBoard)));
	}
}
