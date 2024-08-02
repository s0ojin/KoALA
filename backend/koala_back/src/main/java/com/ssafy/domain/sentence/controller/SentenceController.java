package com.ssafy.domain.sentence.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.domain.sentence.model.dto.request.SentenceTestRequest;
import com.ssafy.domain.sentence.model.dto.response.SentenceDictationResponse;
import com.ssafy.domain.sentence.model.dto.response.SentenceTestResponse;
import com.ssafy.domain.sentence.service.SentenceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sentences")
public class SentenceController {

	private final SentenceService sentenceService;

	@GetMapping
	public ResponseEntity<?> getDictationSentence(@RequestParam("topic") String topic) {
		List<SentenceDictationResponse> sentenceList = sentenceService.randomSentence(topic);
		if (sentenceList == null || sentenceList.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(sentenceList);
		}
	}

	@PostMapping("writing-test")
	public ResponseEntity<?> testWritingPapers(@RequestBody List<SentenceTestRequest> sentenceTestAnswers) {
		List<SentenceTestResponse> sentenceTestResult = sentenceService.testWritingPaper(sentenceTestAnswers);
		return ResponseEntity.ok().body(sentenceTestResult);
	}
}
