package com.ssafy.domain.image.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.domain.image.model.dto.response.TextResponse;
import com.ssafy.domain.image.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

	private final ImageService imageService;

	@PostMapping
	public ResponseEntity<?> imageToText(@RequestParam("file") MultipartFile file) throws IOException {
		String response = imageService.imageToText(file);
		// to. 윤서영...
		// 파싱을 못하는 못난 웅니라서 미아내... 흑흑
		// imageToText에서 String으로 문장을 주는거야!!
		// 그럼 맞춤법 검사기 돌려서 json 객체로 바꿔서 보내면 됑.
		// 일단 response 객체는 TextResponse로 만들어두었습니다.
		// 쪽....
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
