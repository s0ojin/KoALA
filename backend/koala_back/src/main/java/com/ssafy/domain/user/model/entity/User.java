package com.ssafy.domain.user.model.entity;

import com.ssafy.domain.board.model.entity.Board;
import com.ssafy.domain.board.model.entity.BoardComment;
import com.ssafy.domain.koala.model.entity.Koala;
import com.ssafy.domain.lecture.model.entity.Lecture;
import com.ssafy.domain.lecture.model.entity.LectureNote;
import com.ssafy.domain.lecture.model.entity.RegisteredLecture;
import com.ssafy.domain.sentence.model.entity.ReviewSentence;
import com.ssafy.domain.sentence.model.entity.Sentence;
import com.ssafy.domain.user.model.validation.UserValidation;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.ssafy.domain.user.model.validation.UserValidation.*;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User implements UserDetails {
// Spring Security는 인증 및 권한 부여 과정에서 UserDetails 객체를 사용
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

    // test용
    public User(String loginId, String password, Auth auth, String name, String nickname, Integer leaves, Long userExp, Integer userLevel) {
        this.loginId = loginId;
        this.password = password;
        this.auth = auth;
        this.name = name;
        this.nickname = nickname;
        this.leaves = leaves;
        this.userExp = userExp;
        this.userLevel = userLevel;
    }

    @Builder
    public User(
            final String loginId,
            final String password,
            final Auth auth,
            final String name,
            final String nickname,
            final Integer leaves,
            final Koala koala,
            final Long userExp,
            final Integer userLevel) {
        validate(loginId, password, auth, name, nickname, leaves, koala, userExp, userLevel);
        this.loginId = loginId;
        this.password = password;
        this.auth = auth;
        this.name = name;
        this.nickname = nickname;
        this.leaves = leaves;
        this.koala = koala;
        this.userExp = userExp;
        this.userLevel = userLevel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 알아보기 쉽게 일반적으로 이름 반환한다고 함
        return List.of(new SimpleGrantedAuthority(auth.getAuthName()));
    }

    @Override
    public String getUsername() {
        // 유일한 값
        return this.loginId;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
