package com.ssafy.domain.lecture.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "registered_lecture")
public class RegisteredLecture implements Serializable {

    @EmbeddedId
    private RegisteredLectureId id;

    @ManyToOne(fetch = LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @MapsId("lectureId")
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public RegisteredLecture(User user, Lecture lecture) {
        this.user = user;
        this.lecture = lecture;
        this.id = new RegisteredLectureId(user.getUserId(), lecture.getLectureId());
    }


}
