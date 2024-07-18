package com.ssafy.core.sentence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.Date;

public class Sentence {
    @Id
    @Column(name = "sentence_id")
    private Long sentenceId;
    @Column(name = "setence_text")
    private String sentenceText;
    @Column(name = "topic_category")
    String topicCategory;
    @Column(name = "sentence_length")
    private Integer senetenceLength;
    @Column(name = "sentence_created_at")
    private Date sentenceCreatedAt;
}
