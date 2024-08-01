package com.ssafy.domain.board.model.dto.request;

import static lombok.AccessLevel.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.board.model.entity.Board;
import com.ssafy.domain.user.model.entity.User;

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
public class BoardCreateRequest {

	@JsonProperty("board_title")
	private String title;

	@JsonProperty("board_content")
	private String content;

	@JsonProperty("board_img_url")
	private List<MultipartFile> boardImages = new ArrayList<>();

	public Board toEntity(User user) {
		return Board.builder()
			.title(title)
			.content(content)
			.user(user)
			.build();
	}
}
