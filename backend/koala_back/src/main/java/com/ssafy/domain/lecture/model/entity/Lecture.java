package com.ssafy.domain.lecture.model.entity;

import com.ssafy.domain.sentence.model.entity.LectureSentence;
import com.ssafy.domain.user.model.entity.UserDetail;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "lectures")
@NoArgsConstructor(access = PROTECTED)
public class Lecture {

    @Id @GeneratedValue
    @Column(name = "lecture_id")
    private Long lectureId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "teacher_id")
    private UserDetail teacher;

    @Column(name = "lecture_title")
    private String lectureTitle;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @Column(name = "lecture_url")
    private String lectureUrl;

    @OneToMany(mappedBy = "lecture", fetch = LAZY)
    private List<LectureNote> lectureNotes = new ArrayList<>();

    @OneToMany(mappedBy = "lectureDayId.lecture", fetch = LAZY) // 강의는 없어지지 않는다
    private List<LectureDay> lectureDays = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", fetch = LAZY)
    private List<LectureSentence> lectureSentences = new ArrayList<>();
}
