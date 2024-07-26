package com.ssafy.domain.sentence.service;

import com.ssafy.domain.sentence.model.entity.Sentence;
import com.ssafy.domain.sentence.repository.SentenceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SentenceServiceImpl implements SentenceService {
    private SentenceRepository sentenceRepository;

    @Override
    public List<Sentence> randomSentenceByTopic(String topic) {
//        if (topic.equals("사용자")) {
//            return sentenceRepository.
//        } else {
//            return sentenceRepository.findRandomSentencesByTopic(topic);
//        }
        return null;
    }
}
