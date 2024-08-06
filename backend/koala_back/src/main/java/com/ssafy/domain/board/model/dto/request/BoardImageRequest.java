package com.ssafy.domain.board.model.dto.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoardImageRequest {

	private Long boardId;
	private List<MultipartFile> boardImages;

}
