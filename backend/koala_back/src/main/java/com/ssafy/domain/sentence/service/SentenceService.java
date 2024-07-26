package com.ssafy.domain.sentence.service;

import com.ssafy.domain.sentence.model.dto.response.SentenceDictationResponse;

import java.util.List;

public interface SentenceService {
    public List<SentenceDictationResponse> randomSentence(String topic);

}
