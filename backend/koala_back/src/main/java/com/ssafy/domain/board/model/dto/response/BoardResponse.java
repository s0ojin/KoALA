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
	private String nickname;
	private int commentNum;
	private int likeCount;
	private int hit;
	private String createdAt;
	private String thumbnail;

	public static BoardResponse toDto(Board board) {
		return BoardResponse.builder()
			.boardId(board.getId())
			.title(board.getTitle())
			.content(board.getContent())
			.nickname(board.getUser().getNickname())
			.commentNum(board.getCommentNum())
			.hit(board.getHit())
			.createdAt(board.getBoardCreatedAt().toString())
			.thumbnail(board.getBoardImages().isEmpty() ? null : board.getBoardImages().get(0).getBoardImgUrl())
			.build();
	}
}
