package com.ssafy.core.sentence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class ReviewSentence {

    @Id
    @Column(name = "review_sentence_id")
    private Long reviewSentenceId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "sentece_id")
    private Long sentenceId;
    @Column(name = "review_sentence_created_at")
    private Date reviewSentenceCreatedAt;
}
