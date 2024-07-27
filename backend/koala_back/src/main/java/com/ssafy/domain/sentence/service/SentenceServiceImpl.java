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

        for(int i = 0; i < writingPaper.size(); i++){
//            SentenceTestRequest question = writingPaper.get(i);

        }


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

    public String makeResultTag(String originText, String userText) {
        StringBuilder result = new StringBuilder();
        int correctIndex = 0;
        int answerIndex = 0;
        while (correctIndex < originText.length() && answerIndex < userText.length()) {
            char correctChar = originText.charAt(correctIndex);
            char answerChar = userText.charAt(answerIndex);

            if (correctChar == answerChar) {
                result.append(correctChar);  // 정답인 경우
                correctIndex++;
                answerIndex++;
            } else {
                if (correctChar == ' ') {
                    // 정답에서는 띄어야 하는데 답안이 공백이 아닌 경우
                    result.append("<span class='extra-char'>").append(answerChar).append("</span>");
                    correctIndex++;
                } else if (answerChar == ' ') {
                    // 정답에서는 들여쓰기 해야 하는데 답안이 공백인 경우
                    result.append("<span class='missing-char'> </span>");
                    answerIndex++;
                } else {
                    // 글자 자체가 틀린 경우
                    result.append("<span class='char-error'>").append(answerChar).append("</span>");
                    correctIndex++;
                    answerIndex++;
                }
            }
        }

        // 남은 답안 인덱스 처리
        while (answerIndex < userText.length()) {
            result.append("<span class='char-error'>").append(userText.charAt(answerIndex)).append("</span>");
            answerIndex++;
        }

        return result.toString();
    }
}
