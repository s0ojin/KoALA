package com.ssafy.core.board.model.entity;

import jakarta.persistence.*;

@Entity
public class BoardImage {

    @Id
    @GeneratedValue
    @Column(name = "board_img_id")
    private Long boardImgId;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "board_img_url")
    private String boardImgUrl;

}
