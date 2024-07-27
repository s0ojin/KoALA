package com.ssafy.domain.review.service;

import com.ssafy.domain.review.model.dto.request.ReviewSaveRequest;
import com.ssafy.domain.review.repository.ReviewRepository;
import com.ssafy.domain.sentence.model.entity.ReviewSentence;
import com.ssafy.domain.sentence.model.entity.Sentence;
import com.ssafy.domain.sentence.repository.SentenceRepository;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.global.common.UserInfoProvider;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    SentenceRepository sentenceRepository;
    UserInfoProvider userInfoProvider;

    @Override
    @Transactional
    public void createReviewSentence(ReviewSaveRequest reviewSaveRequest) {
        Sentence sentence = sentenceRepository.findById(reviewSaveRequest.getSentenceId()).orElseThrow();
        Optional<User> currentUser = userInfoProvider.getCurrentUser();
        if(currentUser.isEmpty()) {
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }
        ReviewSentence reviewSentence = reviewSaveRequest.toReviewSentenceEntity(sentence, currentUser.get());
        reviewRepository.save(reviewSentence);
    }

}
