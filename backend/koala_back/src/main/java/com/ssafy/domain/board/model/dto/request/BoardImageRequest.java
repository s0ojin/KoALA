package com.ssafy.domain.board.model.dto.request;

import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class BoardImageRequest {

	private Long boardId;
	private List<MultipartFile> boardImages = new ArrayList<>();

}
