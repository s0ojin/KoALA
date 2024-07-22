package com.ssafy.domain.sentence.model.entity;

import com.ssafy.domain.lecture.model.entity.Lecture;
import jakarta.persistence.*;

@Entity
public class LectureSentence {
    @Id
    @Column(name = "lecture_sentence_id")
    private Long lectureSentenceId;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "sentence_id")
    private Sentence sentence;

}
