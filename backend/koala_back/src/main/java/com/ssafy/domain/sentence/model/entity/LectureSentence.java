package com.ssafy.domain.sentence.model.entity;

import com.ssafy.domain.lecture.model.entity.Lecture;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "lecture_sentences")
@NoArgsConstructor(access = PROTECTED)
public class LectureSentence {
    @Id
    @Column(name = "lecture_sentence_id")
    private Long lectureSentenceId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sentence_id")
    private Sentence sentence;

}
