package com.ssafy.domain.lecture.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class LectureDayId implements Serializable {
    @Column(name = "day")
    private Integer day;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
