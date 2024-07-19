package com.ssafy.core.board.model.entity;

import com.ssafy.core.user.model.entity.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_content")
    private String content;

    @Column(name = "board_created_at")
    private Date boardCreatedAt;

    @Column(name = "board_modified_at")
    private Date boardModifiedAt;

    @Column(name = "hit")
    private Integer hit;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardComment> boardComments;
}
