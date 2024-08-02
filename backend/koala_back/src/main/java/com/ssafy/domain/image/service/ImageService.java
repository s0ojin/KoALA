package com.ssafy.domain.image.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	String imageToText(MultipartFile multipartFile) throws IOException;
}
