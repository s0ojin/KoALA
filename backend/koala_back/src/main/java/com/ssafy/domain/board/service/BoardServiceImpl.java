package com.ssafy.domain.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.domain.board.model.dto.request.BoardCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardResponse;
import com.ssafy.domain.board.repository.BoardRepository;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.global.common.UserInfoProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {

	private final UserInfoProvider userInfoProvider;
	private final BoardRepository boardRepository;

	@Override
	@Transactional
	public BoardResponse createBoard(BoardCreateRequest boardCreateRequest) {
		User user = userInfoProvider.getCurrentUser();
		return BoardResponse.toDto(boardRepository.save(boardCreateRequest.toEntity(user)));
	}
}
