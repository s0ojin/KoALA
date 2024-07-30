package com.ssafy.domain.image.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageServiceImpl implements ImageService {

    private static final String bucketName = "koalabucket1";
    private final AmazonS3 amazonS3;

    @Override
    public String saveImage(MultipartFile multipartFile) throws IOException {
        String originalName = multipartFile.getOriginalFilename();
        String filename = System.currentTimeMillis() + "_" + originalName; // 파일 이름 중복 방지

        // 메타데이터 설정
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());
        objectMetadata.setContentLength(multipartFile.getInputStream().available());

        // S3에 파일 업로드
        amazonS3.putObject(bucketName, filename, multipartFile.getInputStream(), objectMetadata);

        // 업로드된 파일의 URL 반환
        String accessUrl = amazonS3.getUrl(bucketName, filename).toString();
        log.info("File uploaded to S3: {}", accessUrl);
        return accessUrl;
    }
}
