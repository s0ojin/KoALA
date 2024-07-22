package com.ssafy.domain.sentence.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "sentences")
@NoArgsConstructor(access = PROTECTED)
public class Sentence {

    @Id @GeneratedValue
    @Column(name = "sentence_id")
    private Long sentenceId;

    @Column(name = "setence_text")
    private String sentenceText;

    @Column(name = "topic_category")
    String topicCategory;

    @Column(name = "sentence_length")
    private Integer senetenceLength;

    @Column(name = "sentence_created_at")
    private LocalDateTime sentenceCreatedAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sentence", cascade = ALL, orphanRemoval = true, fetch = LAZY)
    private List<LectureSentence> lectureSentences = new ArrayList<>();

    @OneToMany(mappedBy = "sentence", cascade = ALL, orphanRemoval = true, fetch = LAZY)
    private List<ReviewSentence> reviewSentences = new ArrayList<>();
}
