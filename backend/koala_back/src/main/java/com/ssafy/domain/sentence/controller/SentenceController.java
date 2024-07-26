package com.ssafy.domain.sentence.controller;

import com.ssafy.domain.sentence.model.dto.response.SentenceDictationResponse;
import com.ssafy.domain.sentence.service.SentenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sentences")
public class SentenceController {

    private final SentenceService sentenceService;
    @GetMapping
    public ResponseEntity<?> getDictationSentence(@RequestParam String topic){
        List<SentenceDictationResponse> sentenceList = sentenceService.randomSentence(topic);
        if(sentenceList == null || sentenceList.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok().body(sentenceList);
        }
    }
}
