package com.ssafy.domain.board.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Entity
@Table(name = "board")
@NoArgsConstructor(access = PROTECTED)
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "board_title", nullable = false)
    private String title;

    @Column(name = "board_content", nullable = false)
    private String content;

    @Column(name = "board_created_at", nullable = false)
    private LocalDateTime boardCreatedAt = LocalDateTime.now();

    @Column(name = "board_modified_at")
    private LocalDateTime boardModifiedAt;

    @Column(name = "hit", nullable = false)
    @ColumnDefault("0")
    private Integer hit;

    @Column(name = "comment_num", nullable = false)
    @ColumnDefault("0")
    private Integer commentNum;

    @OneToMany(mappedBy = "board", cascade = ALL, orphanRemoval = true, fetch = LAZY)
    private List<BoardComment> boardComments = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = ALL, orphanRemoval = true, fetch = LAZY)
    private List<BoardImage> boardImages = new ArrayList<>();
}
