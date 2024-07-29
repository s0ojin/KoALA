package com.ssafy.domain.sentence.service;

import java.util.List;

import com.ssafy.domain.sentence.model.dto.request.SentenceTestRequest;
import com.ssafy.domain.sentence.model.dto.response.SentenceDictationResponse;
import com.ssafy.domain.sentence.model.dto.response.SentenceTestResponse;

public interface SentenceService {
	// 랜덤 10개 문장 반환
	List<SentenceDictationResponse> randomSentence(String topic);

	// 채점 알고리즘
	List<SentenceTestResponse> testWritingPaper(List<SentenceTestRequest> writingPaper);

	// 채점 태그 변환 알고리즘
	String makeResultTag(String correct, String answer);
}
