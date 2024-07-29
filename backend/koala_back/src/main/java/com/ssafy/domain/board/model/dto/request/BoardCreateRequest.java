package com.ssafy.domain.board.model.dto.request;

import static lombok.AccessLevel.*;

import com.ssafy.domain.board.model.entity.Board;
import com.ssafy.domain.user.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class BoardCreateRequest {

	private String title;
	private String content;

	public Board toEntity(User user) {
		return Board.builder()
			.title(title)
			.content(content)
			.user(user)
			.build();
	}
}
