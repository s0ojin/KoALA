package com.ssafy.domain.sentence.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sentence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LectureSentence> lectureSentences;

    @OneToMany(mappedBy = "sentence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReviewSentence> reviewSentences;
}
