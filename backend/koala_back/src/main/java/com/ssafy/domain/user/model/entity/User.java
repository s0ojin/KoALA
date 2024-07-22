package com.ssafy.domain.user.model.entity;

import com.ssafy.domain.board.model.entity.Board;
import com.ssafy.domain.board.model.entity.BoardComment;
import com.ssafy.domain.koala.model.entity.Koala;
import com.ssafy.domain.lecture.model.entity.Lecture;
import com.ssafy.domain.lecture.model.entity.LectureNote;
import com.ssafy.domain.lecture.model.entity.RegisteredLecture;
import com.ssafy.domain.sentence.model.entity.ReviewSentence;
import com.ssafy.domain.sentence.model.entity.Sentence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login_id", nullable = false)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "auth_id", nullable = false)
    private Auth auth;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "leaves", nullable = false)
    private Integer leaves;

    @OneToOne(cascade = ALL, fetch = LAZY, orphanRemoval = true)
    @JoinColumn(name = "koala_id")
    private Koala koala;

    @Column(name = "user_exp", nullable = false)
    private Long userExp;

    @Column(name = "user_level", nullable = false)
    private Integer userLevel;

    @Column(name = "user_created_at", nullable = false)
    private LocalDateTime userCreatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "teacher", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<Lecture> lectures = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<Sentence> sentences = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<ReviewSentence> reviewSentences = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<StudyTime> studyTimes = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private UserDetail userDetail;

    @OneToMany(mappedBy = "user", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<RegisteredLecture> registeredLectures = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<LectureNote> lectureNotes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private List<BoardComment> boardComments = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = ALL, fetch = LAZY, orphanRemoval = true)
    private Ranking ranking;

}
