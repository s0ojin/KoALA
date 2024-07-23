package com.ssafy.domain.sentence.model.entity;

import com.ssafy.domain.lecture.model.entity.Lecture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "lecture_sentences")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class LectureSentence {

    @Id
    @GeneratedValue
    @Column(name = "lecture_sentence_id")
    private Long lectureSentenceId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "sentence_id", nullable = false)
    private Sentence sentence;

}
