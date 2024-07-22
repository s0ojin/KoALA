package com.ssafy.domain.lecture.model.entity;

import com.ssafy.domain.sentence.model.entity.LectureSentence;
import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "lectures")
@NoArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue
    @Column(name = "lecture_id")
    private Long lectureId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "user_id", nullable = false)
    private User teacher;

    @Column(name = "lecture_title", nullable = false)
    private String lectureTitle;

    @Column(name = "lecture_detail")
    private String lectureDetail;

    @Column(name = "lecture_url", nullable = false)
    private String lectureUrl;

    @Column(name = "is_open", nullable = false)
    private int isOpen = 1;

    @OneToMany(mappedBy = "lecture", fetch = LAZY)
    private List<LectureNote> lectureNotes = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", fetch = LAZY)
    private List<LectureSentence> lectureSentences = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<RegisteredLecture> registeredLectures = new ArrayList<>();

    public Lecture(User teacher, String lectureTitle, String lectureDetail, String lectureUrl, int isOpen) {
        this.teacher = teacher;
        this.lectureTitle = lectureTitle;
        this.lectureDetail = lectureDetail;
        this.lectureUrl = lectureUrl;
        this.isOpen = isOpen;
    }

//    public Long getLectureId() {
//        return lectureId;
//    }
}
