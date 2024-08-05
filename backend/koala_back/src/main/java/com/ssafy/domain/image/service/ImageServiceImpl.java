package com.ssafy.domain.image.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.ssafy.domain.image.model.dto.request.GeminiRequest;
import com.ssafy.domain.image.model.dto.response.TextResponse;

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
		String extractedText = geminiService.getCompletionWithImage(
			"이 이미지에서 받아쓰기로 사용할 수 있는 문장을 추출하고 싶어 문장의 길이는 띄어쓰기 포함 5자에서 45자이내여야 해\n"
				+ "따옴표로 끝나는 구체적인 문장만 반환해줘. 문장은 따옴표로 끝나야해.", inlineData);
		log.info("Extracted text from image: {}", extractedText);

		// 텍스트를 문장별로 분리하여 객체 리스트에 담음
		List<String> texts = splitIntoTexts(extractedText);

		return extractedText;
	}

	private List<String> splitIntoTexts(String text) {
		return Pattern.compile("")
			.splitAsStream(text.trim())
			.map(String::trim)
			.filter(sentence -> !sentence.isEmpty())
			.collect(Collectors.toList());
	}
}
