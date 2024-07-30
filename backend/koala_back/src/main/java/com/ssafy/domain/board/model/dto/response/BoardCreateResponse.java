package com.ssafy.domain.board.model.dto.response;

import static lombok.AccessLevel.*;

import org.springframework.data.domain.Page;

import com.ssafy.domain.board.model.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class BoardCreateResponse {

	private Long boardId;
	private String title;
	private String content;
	private String nickname;
	private int commentNum;
	private int likeCount;
	private int viewCount;
	private String createdAt;

	public static BoardCreateResponse toDto(Board board) {
		return BoardCreateResponse.builder()
			.boardId(board.getId())
			.title(board.getTitle())
			.content(board.getContent())
			.nickname(board.getUser().getNickname())
			.commentNum(board.getCommentNum())
			.viewCount(board.getHit())
			.createdAt(board.getBoardCreatedAt().toString())
			.build();
	}
}
