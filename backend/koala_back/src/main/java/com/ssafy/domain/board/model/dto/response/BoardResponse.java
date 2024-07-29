package com.ssafy.domain.board.model.dto.response;

import static lombok.AccessLevel.*;

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
	private int commentCount;
	private int likeCount;
	private int viewCount;
	private String createdAt;
	private String modifiedAt;

	public static BoardResponse toDto(Long boardId, String title, String content, Long userId, int commentCount,
		int likeCount, int viewCount, String createdAt, String modifiedAt) {
		return BoardResponse.builder()
			.boardId(boardId)
			.title(title)
			.content(content)
			.userId(userId)
			.commentCount(commentCount)
			.likeCount(likeCount)
			.viewCount(viewCount)
			.createdAt(createdAt)
			.modifiedAt(modifiedAt)
			.build();
	}
}
