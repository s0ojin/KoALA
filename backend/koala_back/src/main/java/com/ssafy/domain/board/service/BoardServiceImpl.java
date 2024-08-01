package com.ssafy.domain.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.domain.board.model.dto.request.BoardCreateRequest;
import com.ssafy.domain.board.model.dto.response.BoardCommentResponse;
import com.ssafy.domain.board.model.dto.response.BoardResponse;
import com.ssafy.domain.board.model.dto.response.BoardDetailResponse;
import com.ssafy.domain.board.model.entity.Board;
import com.ssafy.domain.board.model.validation.BoardValidation;
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
	private final BoardCommentService boardCommentService;

	@Override
	@Transactional
	public BoardResponse createBoard(BoardCreateRequest boardCreateRequest) {

		BoardValidation.validateKoreanAndNumeric(boardCreateRequest.getTitle());
		BoardValidation.validateKoreanAndNumeric(boardCreateRequest.getContent());

		User user = userInfoProvider.getCurrentUser();
		return BoardResponse.toDto(boardRepository.save(boardCreateRequest.toEntity(user)));
	}

	@Override
	public Page<BoardResponse> getBoards(Pageable pageable) {
		Page<Board> boards = boardRepository.findAll(pageable);
		return boards.map(BoardResponse::toDto);
	}

	@Override
	public BoardDetailResponse getBoard(Long boardId, Pageable pageable) {
		Page<BoardCommentResponse> comments = boardCommentService.getCommentsByBoardId(boardId, pageable);
		return BoardDetailResponse.toDto(boardRepository.findById(boardId).orElseThrow(), comments);
	}

	@Override
	public Page<BoardResponse> getBoardsSortedByHit(Pageable pageable) {
		Page<Board> boards = boardRepository.findAllByOrderByHitDesc(pageable);
		return boards.map(BoardResponse::toDto);
	}

	@Override
	public Page<BoardResponse> getBoardsByKeyword(String keyword, Pageable pageable) {
		Page<Board> boards = boardRepository.findAllByTitleContaining(keyword, pageable);
		return boards.map(BoardResponse::toDto);
	}


	@Override
	public Page<BoardResponse> getBoardsByUser(Pageable pageable) {
		User user = userInfoProvider.getCurrentUser();
		Page<Board> boards = boardRepository.findAllByUser(user, pageable);
		return boards.map(BoardResponse::toDto);
	}

	@Override
	@Transactional
	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardRepository.findById(boardId).orElseThrow().getId());
	}

	@Override
	@Transactional
	public void increaseCommentNum(Long boardId) {
		Board board = boardRepository.findById(boardId).orElseThrow();
		board.increaseCommentNum();
		boardRepository.save(board);
	}

	@Override
	@Transactional
	public void increaseHit(Long boardId) {
		Board board = boardRepository.findById(boardId).orElseThrow();
		board.increaseHit();
		boardRepository.save(board);
	}
}
