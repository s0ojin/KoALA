package com.ssafy.domain.sentence.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "review_sentences")
@NoArgsConstructor(access = PROTECTED)
public class ReviewSentence {

    @Id @GeneratedValue
    @Column(name = "review_sentence_id")
    private Long reviewSentenceId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sentece_id")
    private Sentence sentence;
    
    @Column(name = "review_sentence_created_at")
    private LocalDateTime reviewSentenceCreatedAt;


}
