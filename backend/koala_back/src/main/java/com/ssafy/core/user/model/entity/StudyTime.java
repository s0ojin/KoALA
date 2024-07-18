package com.ssafy.core.user.model.entity;

import com.ssafy.core.sentence.model.entity.StudyTimeId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudyTime {
    @EmbeddedId
    private StudyTimeId studyTimeId;

    @Column(name = "talk_time")
    private Integer talkTime;

    @Column(name = "sentence_num")
    private Integer sentenceNum;

    @Column(name = "lecture_num")
    private Integer lectureNum;
}
