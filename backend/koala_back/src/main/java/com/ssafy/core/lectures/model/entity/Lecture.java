package com.ssafy.core.lectures.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Lecture {

    @Id
    @Column(name = "lecture_id")
    private Long lectureId;
    @Column(name = "teacher_id")
    private Long teacherId;
    @Column(name = "lecture_title")
    private String lectureTitle;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "lecture_url")
    private


}
