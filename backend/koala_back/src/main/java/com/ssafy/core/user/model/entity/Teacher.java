package com.ssafy.core.user.model.entity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Teacher {
    @Column(name = "teacher_id")
    private Long teacherId;
    @Column(name = "teacher_introduce")
    private String teacherIntroduce;
    @Column(name = "org_name")
    private String orgName;
}
