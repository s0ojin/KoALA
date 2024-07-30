package com.ssafy.domain.board.model.dto.response;

import static lombok.AccessLevel.*;

import com.ssafy.domain.board.model.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class BoardResponse {

	private Long boardId;
	private String title;
	private String content;
	private Long userId;
	private int commentNum;
	private int likeCount;
	private int viewCount;
	private String createdAt;
	private String modifiedAt;

	public static BoardResponse toDto(Board board) {
		return BoardResponse.builder()
			.boardId(board.getId())
			.title(board.getTitle())
			.content(board.getContent())
			.userId(board.getUser().getUserId())
			.commentNum(board.getCommentNum())
			.viewCount(board.getHit())
			.createdAt(board.getBoardCreatedAt().toString())
			.modifiedAt(board.getBoardModifiedAt() == null ? null : board.getBoardModifiedAt().toString())
			.build();
	}
}
