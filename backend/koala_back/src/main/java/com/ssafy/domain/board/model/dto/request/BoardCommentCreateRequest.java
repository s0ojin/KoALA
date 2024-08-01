package com.ssafy.domain.board.model.dto.request;

import static lombok.AccessLevel.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.board.model.entity.Board;
import com.ssafy.domain.board.model.entity.BoardComment;
import com.ssafy.domain.user.model.entity.User;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class BoardCommentCreateRequest {

	@NotNull(message = "댓글 내용은 필수 입력 값입니다.")
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
