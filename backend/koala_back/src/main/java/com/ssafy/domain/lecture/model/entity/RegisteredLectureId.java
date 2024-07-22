package com.ssafy.domain.lecture.model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static lombok.AccessLevel.*;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class RegisteredLectureId implements Serializable {

    private Long userId;
    private Long lectureId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisteredLectureId)) return false;
        RegisteredLectureId that = (RegisteredLectureId) o;
        return getUserId().equals(that.getUserId()) && getLectureId().equals(that.getLectureId());
    }

    @Override
    public int hashCode() {
        return getUserId().hashCode() + getLectureId().hashCode();
    }

}
