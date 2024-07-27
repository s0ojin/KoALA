package com.ssafy.domain.sentence.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "review_sentences")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class ReviewSentence {

    @Id
    @GeneratedValue
    @Column(name = "review_sentence_id")
    private Long reviewSentenceId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sentece_id", nullable = false)
    private Sentence sentence;

    @Column(name = "review_sentence_created_at", nullable = false)
    private LocalDateTime reviewSentenceCreatedAt = LocalDateTime.now();

}
