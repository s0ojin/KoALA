package com.ssafy.core.lecture.model.entity;

import com.ssafy.core.user.model.entity.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class LectureNote {

    @Id
    @GeneratedValue
    @Column(name = "note_id")
    private Long noteId;

    @Column(name = "note_title")
    private String noteTitle;

    @Column(name = "note_content")
    private String noteContent;

    @Column(name = "note_created_at")
    private Date noteCreatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

}
