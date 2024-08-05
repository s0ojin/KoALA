package com.ssafy.domain.image.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.domain.image.model.dto.response.TextResponse;

public interface ImageService {

	String imageToText(MultipartFile multipartFile) throws IOException;
}
