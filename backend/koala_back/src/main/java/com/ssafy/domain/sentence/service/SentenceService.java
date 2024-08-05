package com.ssafy.domain.sentence.service;

import java.util.List;

import com.ssafy.domain.sentence.model.dto.request.SentenceTestRequest;
import com.ssafy.domain.sentence.model.dto.response.LectureSentenceResponse;
import com.ssafy.domain.sentence.model.dto.response.SentenceDictationResponse;
import com.ssafy.domain.sentence.model.dto.response.SentenceTestResponse;

public interface SentenceService {

	List<SentenceDictationResponse> randomSentence(String topic);

	List<SentenceTestResponse> testWritingPaper(List<SentenceTestRequest> writingPaper);

	String makeResultTag(String correct, String answer);

	List<LectureSentenceResponse> getLectureSentences(Long lectureId);

}

