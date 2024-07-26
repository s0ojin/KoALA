package com.ssafy.domain.sentence.service;

import com.ssafy.domain.review.model.dto.request.ReviewSentenceRequest;
import com.ssafy.domain.sentence.model.dto.request.SentenceTestRequest;
import com.ssafy.domain.sentence.model.dto.response.SentenceDictationResponse;
import com.ssafy.domain.sentence.model.dto.response.SentenceTestResponse;
import com.ssafy.domain.sentence.model.entity.ReviewSentence;
import com.ssafy.domain.sentence.model.entity.Sentence;
import com.ssafy.domain.sentence.repository.SentenceRepository;
import com.ssafy.domain.user.repository.ReviewSentenceRepository;
import com.ssafy.global.common.UserInfoProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class SentenceServiceImpl implements SentenceService {
    private final SentenceRepository sentenceRepository;
    private final ReviewSentenceRepository reviewSentenceRepository;
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

    @Override
    public List<SentenceTestResponse> testWritingPaper(List<SentenceTestRequest> writingPaper) {
        // 여기서 받아쓰기 알고리즘 진행해주세요...

        int leaves;
        int sentenceNum;
        List<ReviewSentenceRequest> wrongAnswer = List.of(); // 오답 문장
        List<ReviewSentence> reviewSentences = wrongAnswer.stream()
                .map(request -> {
                    Sentence sentence = sentenceRepository.findById(request.getSentenceId())
                            .orElseThrow(() -> new IllegalArgumentException("Invalid sentence ID: " + request.getSentenceId()));
                    return request.toEntity(sentence, userInfoProvider.getCurrentUser().get());
                })
                .collect(Collectors.toList());

        reviewSentenceRepository.saveAll(reviewSentences);

        return List.of();
    }


}
