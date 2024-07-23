package com.ssafy.domain.user.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class Ranking {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne(fetch = LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "ranking", nullable = false)
    private Integer ranking;

}
