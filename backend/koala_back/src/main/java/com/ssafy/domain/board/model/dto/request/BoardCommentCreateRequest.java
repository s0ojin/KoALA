package com.ssafy.domain.board.model.dto.request;

import static lombok.AccessLevel.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.board.model.entity.Board;
import com.ssafy.domain.board.model.entity.BoardComment;
import com.ssafy.domain.user.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class BoardCommentCreateRequest {

	@JsonProperty("comment_content")
	private String commentContent;

	public BoardComment toEntity(User user, Board board) {
		return BoardComment.builder()
			.commentContent(commentContent)
			.user(user)
			.board(board)
			.build();
	}

}
