package com.ssafy.domain.sentence.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.domain.review.model.dto.request.ReviewSentenceRequest;
import com.ssafy.domain.review.repository.ReviewRepository;
import com.ssafy.domain.sentence.model.dto.request.SentenceTestRequest;
import com.ssafy.domain.sentence.model.dto.response.SentenceDictationResponse;
import com.ssafy.domain.sentence.model.dto.response.SentenceTestResponse;
import com.ssafy.domain.sentence.model.entity.ReviewSentence;
import com.ssafy.domain.sentence.model.entity.Sentence;
import com.ssafy.domain.sentence.repository.SentenceRepository;
import com.ssafy.domain.user.model.entity.User;
import com.ssafy.domain.user.repository.UserRepository;
import com.ssafy.global.common.UserInfoProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SentenceServiceImpl implements SentenceService {
	private final SentenceRepository sentenceRepository;
	private final UserRepository userRepository;
	private final ReviewRepository reviewRepository;
	private final UserInfoProvider userInfoProvider;

	@Override
	@Transactional
	public List<SentenceDictationResponse> randomSentence(String topic) {
		List<Sentence> sentences;
		if (topic.isEmpty()) {
			sentences = sentenceRepository.findRandomSentences(userInfoProvider.getCurrentUserId());
		} else if (topic.equals("사용자")) {
			sentences = sentenceRepository.findRandomSentencesByUser(userInfoProvider.getCurrentUserId());
		} else {
			sentences = sentenceRepository.findRandomSentencesByTopic(topic);
		}

		return sentences.stream().map(SentenceDictationResponse::toDto).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<SentenceTestResponse> testWritingPaper(List<SentenceTestRequest> writingPaper) {
		List<SentenceTestResponse> sentenceTestResponses = new ArrayList<>();
		List<ReviewSentence> reviewSentences = new ArrayList<>();
		User user = userInfoProvider.getCurrentUser();

		int leaves = 0;

		for (SentenceTestRequest request : writingPaper) {
			Optional<Sentence> originSentence = sentenceRepository.findById(request.getSentenceId());
			if (originSentence.isEmpty()) {
				return null;
			}

			String originText = originSentence.get().getSentenceText();
			String userText = request.getUserSentence();
			String resultTag;
			boolean correct;

			if (originText.equals(userText)) {
				resultTag = userText;
				correct = true;
				if (request.isToggled()) { // 토클을 켜고 함
					leaves += 1;
				} else { // 토글을 끄고 함
					leaves += 2;
				}
			} else {
				resultTag = makeResultTag(originText, userText);
				reviewSentences.add(
					new ReviewSentenceRequest(request.getSentenceId()).toEntity(originSentence.get(), user));
				correct = false;
			}

			sentenceTestResponses.add(new SentenceTestResponse(originText, userText, resultTag, correct));
		}

		// 1. 복습페이지에 틀린 문장 저장
		reviewRepository.saveAll(reviewSentences);
		//        System.out.println(leaves);
		// 2. 유칼립투스 증가
		// 문제 별로 토글을 키고 했다면 -> 1개
		// 문제 별로 토글을 끄고 했다면 -> 2개
		user.setLeaves(user.getLeaves() + leaves);
		System.out.println(user.getLeaves());
		userRepository.save(user);

		return sentenceTestResponses; // 3. 틀린g거 보여주기
	}

	@Override
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
					// 정답에서는 공백인데 답안이 공백이 아닌 경우
					//                    result.append("<span class='extra-char'>").append(answerChar).append("</span>");
					result.append("<span class='extra-char'> </span>");
					correctIndex++;
				} else if (answerChar == ' ') {
					// 정답에서는 공백이 아닌데 답안이 공백인 경우
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

		if (userText.length() < originText.length()) {
			correctIndex = userText.length();
			while (correctIndex < originText.length()) {
				result.append("<span class='char-error'>").append(originText.charAt(correctIndex)).append("</span>");
				correctIndex++;
			}
		}

		return result.toString();
	}
}
