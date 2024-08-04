package com.ssafy.domain.image.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.ssafy.domain.image.model.dto.request.GeminiRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageServiceImpl implements ImageService {

	private static final String bucketName = "koalabucket1";
	private final AmazonS3 amazonS3;
	private final GeminiService geminiService;

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

		// 이미지 데이터를 Base64로 인코딩
		byte[] imageBytes = multipartFile.getBytes();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);

		// 제미나이 API를 사용하여 텍스트 추출
		GeminiRequest.InlineData inlineData = new GeminiRequest.InlineData(multipartFile.getContentType(), base64Image);
		String extractedText = geminiService.getCompletionWithImage("이 이미지에서 받아쓰기로 사용할 수 있는 5자 이상 45자 이하의 문장을 추출해줘\n"
			+ "따옴표로 끝나는 구체적인 문장만 반환해줘. 다른 말은 필요없어", inlineData);
		log.info("Extracted text from image: {}", extractedText);

		return extractedText;
	}
}
