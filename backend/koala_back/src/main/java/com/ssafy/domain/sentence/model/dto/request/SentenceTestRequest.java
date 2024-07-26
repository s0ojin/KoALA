package com.ssafy.domain.sentence.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SentenceTestRequest {
    private Long sentenceId;
    String userSentence;
    boolean isToggled;
}
