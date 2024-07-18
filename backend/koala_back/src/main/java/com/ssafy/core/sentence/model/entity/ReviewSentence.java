package com.ssafy.core.sentence.model.entity;

import com.ssafy.core.user.model.entity.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ReviewSentence {

    @Id
    @Column(name = "review_sentence_id")
    private Long reviewSentenceId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "sentece_id")
    private Long sentenceId;
    
    @Column(name = "review_sentence_created_at")
    private Date reviewSentenceCreatedAt;


}
