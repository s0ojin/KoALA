package com.ssafy.core.sentence.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LectureSentence {
    @Id
    @Column(name = "lecture_sentence_id")
    private Long lectureSentenceId;
    @Column(name = "lecture_id")
    private Long lectureId;
    @Column(name = "sentence_id")
    private Long sentenceId;
}
