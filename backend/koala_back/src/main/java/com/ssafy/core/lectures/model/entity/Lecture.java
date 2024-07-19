package com.ssafy.core.lectures.model.entity;

import com.ssafy.core.user.model.entity.Teacher;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Lecture {

    @Id
    @Column(name = "lecture_id")
    private Long lectureId;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "lecture_title")
    private String lectureTitle;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "lecture_url")
    private String lectureUrl;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY)
    private List<LectureNote> lectureNotes;

}
