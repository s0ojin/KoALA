package com.ssafy.domain.board.model.dto.response;

import static lombok.AccessLevel.*;

import org.springframework.data.domain.Page;

import com.ssafy.domain.board.model.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class BoardDetailResponse {

	private Long boardId;
	private String title;
	private String content;
	private String nickname;
	private int commentNum;
	private int likeCount;
	private int viewCount;
	private String createdAt;
	private Page<BoardCommentResponse> comments;
	private List<String> boardImages;

	public static BoardDetailResponse toDto(Board board, List<String> boardImages, Page<BoardCommentResponse> comments) {
		return BoardDetailResponse.builder()
			.boardId(board.getId())
			.title(board.getTitle())
			.content(board.getContent())
			.nickname(board.getUser().getNickname())
			.commentNum(board.getCommentNum())
			.viewCount(board.getHit())
			.createdAt(board.getBoardCreatedAt().toString())
			.comments(comments)
			.boardImages(boardImages)
			.build();
	}

	public static BoardDetailResponse toDto(Board board, Page<BoardCommentResponse> comments) {
		return BoardDetailResponse.builder()
				.boardId(board.getId())
				.title(board.getTitle())
				.content(board.getContent())
				.nickname(board.getUser().getNickname())
				.commentNum(board.getCommentNum())
				.viewCount(board.getHit())
				.createdAt(board.getBoardCreatedAt().toString())
				.comments(comments)
				.build();
	}
}
