package com.ssafy.domain.sentence.service;

import com.ssafy.domain.sentence.model.dto.response.SentenceDictationResponse;
import com.ssafy.domain.sentence.model.entity.Sentence;
import com.ssafy.domain.sentence.repository.SentenceRepository;
import com.ssafy.global.common.UserInfoProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class SentenceServiceImpl implements SentenceService {
    private final SentenceRepository sentenceRepository;
    private final UserInfoProvider userInfoProvider;

    @Override
    public List<SentenceDictationResponse> randomSentence(String topic) {
        List<Sentence> sentences;
        if (topic.equals("사용자")) {
            sentences =  sentenceRepository.findRandomSentencesByUser(userInfoProvider.getCurrentUserId());
        } else {
            sentences =  sentenceRepository.findRandomSentencesByTopic(topic);
        }

        return sentences.stream()
                .map(SentenceDictationResponse::toDto)
                .collect(Collectors.toList());
    }
}
