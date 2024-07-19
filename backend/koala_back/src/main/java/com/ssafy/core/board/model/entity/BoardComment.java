package com.ssafy.core.board.model.entity;

import com.ssafy.core.user.model.entity.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BoardComment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_created_at")
    private Date commentCreatedAt;

    @Column(name = "comment_modified_at")
    private Date commentModifiedAt;


}
