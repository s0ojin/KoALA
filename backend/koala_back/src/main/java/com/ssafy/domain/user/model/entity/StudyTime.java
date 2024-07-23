package com.ssafy.domain.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Table(name = "study_time")
@IdClass(StudyTimeId.class)
public class StudyTime implements Serializable {

    @Id
    @Column(name = "time_cal_type")
    private Integer timeCalType;

    @Id
    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "talk_time", nullable = false)
    private Integer talkTime = 0;

    @Column(name = "sentence_num", nullable = false)
    private Integer sentenceNum = 0;

    @Column(name = "lecture_num", nullable = false)
    private Integer lectureNum = 0;
}
