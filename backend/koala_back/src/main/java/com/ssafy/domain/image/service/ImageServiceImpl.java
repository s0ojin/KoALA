package com.ssafy.domain.image.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageServiceImpl implements ImageService {

	private static final String bucketName = "koalabucket1";
	private final AmazonS3 amazonS3;

	@Override
	public String imageToText(MultipartFile multipartFile) throws IOException {
		String originalName = multipartFile.getOriginalFilename();
		String filename = System.currentTimeMillis() + "_" + originalName;

		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType(multipartFile.getContentType());
		objectMetadata.setContentLength(multipartFile.getInputStream().available());

		amazonS3.putObject(bucketName, filename, multipartFile.getInputStream(), objectMetadata);

		String accessUrl = amazonS3.getUrl(bucketName, filename).toString();
		log.info("File uploaded to S3: {}", accessUrl);
		return accessUrl;
	}
}
