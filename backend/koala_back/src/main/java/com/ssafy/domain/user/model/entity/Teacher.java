package com.ssafy.domain.user.model.entity;

import com.ssafy.domain.lecture.model.entity.Lecture;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Teacher {

    @Id
    private Long teacherId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    private User user;

    @Column(name = "teacher_introduce")
    private String teacherIntroduce;
    @Column(name = "org_name")
    private String orgName;

    @OneToMany(mappedBy = "teacher")
    private List<Lecture> lectures;

}
