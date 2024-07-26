package com.ssafy.domain.sentence.model.dto.response;

import com.ssafy.domain.sentence.model.entity.Sentence;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SentenceResponse {
    private Long sentenceId;
    private Long userId;
    private String sentenceText;
    private String topicCategory;
    private Integer sentenceLength;
    private LocalDateTime sentenceCreatedAt;

    public static SentenceResponse toDto(Sentence sentence){
        return SentenceResponse.builder()
                .sentenceId(sentence.getSentenceId())
                .userId(sentence.getUser().getUserId())
                .sentenceText(sentence.getSentenceText())
                .topicCategory(sentence.getTopicCategory())
                .sentenceLength(sentence.getSentenceLength())
                .sentenceCreatedAt(sentence.getSentenceCreatedAt())
                .build();
    }

}
