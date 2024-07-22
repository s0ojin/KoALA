package com.ssafy.domain.lecture.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "lecture_notes")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class LectureNote {

    @Id
    @GeneratedValue
    @Column(name = "note_id", nullable = false)
    private Long noteId;

    @Column(name = "note_title", nullable = false)
    private String noteTitle;

    @Column(name = "note_content", nullable = false)
    private String noteContent;

    @Column(name = "note_created_at", nullable = false)
    private LocalDateTime noteCreatedAt = LocalDateTime.now();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

}
