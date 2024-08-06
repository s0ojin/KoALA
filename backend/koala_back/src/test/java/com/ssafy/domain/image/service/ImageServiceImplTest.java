package com.ssafy.domain.image.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class ImageServiceImplTest {

	private final ImageServiceImpl imageServiceImpl = new ImageServiceImpl(null, null);

	@Test
	void checkSpelling() {
		String testText = "이것은 테스트 문장입니다.";
		String expectedResponse = "이것은 테스트 문장입니다.";

		try {
			String result = imageServiceImpl.checkSpelling(testText);
			assertNotNull(result);
			assertTrue(result.contains(testText)); // 예상된 결과가 포함되어 있는지 확인
		} catch (IOException e) {
			fail("IOException 발생: " + e.getMessage());
		}
	}
}