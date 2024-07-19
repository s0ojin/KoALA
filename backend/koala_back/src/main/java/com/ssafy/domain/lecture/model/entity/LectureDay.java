package com.ssafy.domain.lecture.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class LectureDay {
    @EmbeddedId
    private LectureDayId lectureDayId;
}
