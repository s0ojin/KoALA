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

    final ReviewRepository reviewRepository;
    final SentenceRepository sentenceRepository;
    final UserInfoProvider userInfoProvider;

    @Override
    @Transactional
    public void createReviewSentence(ReviewSaveRequest reviewSaveRequest) {
        Sentence sentence = sentenceRepository.findById(reviewSaveRequest.getSentenceId())
            .orElseThrow(() -> new IllegalArgumentException("해당 문장이 존재하지 않습니다."));

        User currentUser = userInfoProvider.getCurrentUser();
        ReviewSentence reviewSentence = reviewSaveRequest.toReviewSentenceEntity(sentence, currentUser);
        reviewRepository.save(reviewSentence);
    }

    @Override
    @Transactional
    public void deleteReviewSentence(Long reviewSentenceId) {
        ReviewSentence reviewSentence = reviewRepository.findById(reviewSentenceId)
            .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 존재하지 않습니다."));

        User currentUser = userInfoProvider.getCurrentUser();
        if (!reviewSentence.getUser().equals(currentUser)) {
            throw new IllegalArgumentException("해당 리뷰를 삭제할 권한이 없습니다.");
        }

        reviewRepository.delete(reviewSentence);
    }

}
