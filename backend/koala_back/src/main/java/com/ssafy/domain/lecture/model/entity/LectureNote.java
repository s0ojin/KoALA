package com.ssafy.domain.lecture.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "lecture_notes")
@NoArgsConstructor(access = PROTECTED)
public class LectureNote {

    @Id @GeneratedValue
    @Column(name = "note_id")
    private Long noteId;

    @Column(name = "note_title")
    private String noteTitle;

    @Column(name = "note_content")
    private String noteContent;

    @Column(name = "note_created_at")
    private Date noteCreatedAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

}
