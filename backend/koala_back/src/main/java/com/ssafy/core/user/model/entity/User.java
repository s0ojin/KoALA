package com.ssafy.core.user.model.entity;

import com.ssafy.core.board.model.entity.Board;
import com.ssafy.core.board.model.entity.BoardComment;
import com.ssafy.core.koala.model.entity.Koala;
import com.ssafy.core.lecture.model.entity.LectureNote;
import com.ssafy.core.sentence.model.entity.ReviewSentence;
import com.ssafy.core.sentence.model.entity.Sentence;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login_id")
    private String loginId;
    @Column(name = "password")
    private String password;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "name")
    private String name;

    @Column(name = "leaves")
    private Integer leaves;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "koala_id", referencedColumnName = "koala_id")
    private Koala koala;

    @Column(name = "user_level")
    private Integer userLevel;

    @Column(name = "user_created_at")
    private Date userCreatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sentence> sentences;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReviewSentence> reviewSentences;

    @OneToMany(mappedBy = "studyTimeId.user")
    private List<StudyTime> studyTimes;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LectureNote> lectureNotes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board> boards;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardComment> boardComments;

}
