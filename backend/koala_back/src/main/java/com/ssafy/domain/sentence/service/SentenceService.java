package com.ssafy.domain.sentence.service;

import com.ssafy.domain.sentence.model.dto.request.SentenceTestRequest;
import com.ssafy.domain.sentence.model.dto.response.SentenceDictationResponse;
import com.ssafy.domain.sentence.model.dto.response.SentenceTestResponse;

import java.util.List;

public interface SentenceService {
    // 랜덤 10개 문장 반환
    public List<SentenceDictationResponse> randomSentence(String topic);

    // 채점 알고리즘
    public List<SentenceTestResponse> testWritingPaper(List<SentenceTestRequest> writingPaper);

    // 채점 태그 변환 알고리즘
    public String makeResultTag(String correct, String answer);
}
