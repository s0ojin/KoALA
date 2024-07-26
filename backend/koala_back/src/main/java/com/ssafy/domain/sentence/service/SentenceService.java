package com.ssafy.domain.sentence.service;

import com.ssafy.domain.sentence.model.entity.Sentence;

import java.util.List;

public interface SentenceService {
    public List<Sentence> randomSentenceByTopic(String topic);
}
