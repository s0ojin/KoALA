package com.ssafy.domain.sentence.model.entity;

import com.ssafy.domain.user.model.entity.User;
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

    @ManyToOne
    @JoinColumn(name = "sentece_id")
    private Sentence sentence;
    
    @Column(name = "review_sentence_created_at")
    private Date reviewSentenceCreatedAt;


}
