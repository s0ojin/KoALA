package com.ssafy.domain.board.model.dto.response;

import static lombok.AccessLevel.*;

import com.ssafy.domain.board.model.entity.BoardComment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class BoardCommentResponse {

	private Long commentId;
	private String content;
	private String nickname;
	private String createdAt;

	public static BoardCommentResponse toDto(BoardComment boardComment) {
		return BoardCommentResponse.builder()
			.commentId(boardComment.getCommentId())
			.content(boardComment.getCommentContent())
			.nickname(boardComment.getUser().getNickname())
			.createdAt(boardComment.getCommentCreatedAt().toString())
			.build();
	}
}
