package com.ssafy.domain.board.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "board_comment")
@NoArgsConstructor(access = PROTECTED)
public class BoardComment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "comment_content", nullable = false)
    private String commentContent;

    @Column(name = "comment_created_at", nullable = false)
    private LocalDateTime commentCreatedAt = LocalDateTime.now();

    @Column(name = "comment_modified_at")
    private LocalDateTime commentModifiedAt;


}
