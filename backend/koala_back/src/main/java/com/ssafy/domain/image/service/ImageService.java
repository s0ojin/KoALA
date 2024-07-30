package com.ssafy.domain.image.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    /**
     * 이미지를 S3에 업로드하고, 업로드된 이미지의 URL을 반환합니다.
     *
     * 일단은 url을 반환하고 나중에 ai api와 연결 후 response dto 정해서 text list를 반환하는걸로
     * 수정필요합니다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * 이미지는 한장이므로 그냥 MultipartFile을 직접 파라미터로 받는 방식이 더 간단해서
     * 이미지 dto는 만들지 않았습니다.
     */
    String saveImage(MultipartFile multipartFile) throws IOException;
}
