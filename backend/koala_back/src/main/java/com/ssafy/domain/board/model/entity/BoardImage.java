package com.ssafy.domain.board.model.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "board_images")
@NoArgsConstructor(access = PROTECTED)
public class BoardImage {

    @Id
    @GeneratedValue
    @Column(name = "board_img_id")
    private Long boardImgId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "board_img_url")
    private String boardImgUrl;

}
