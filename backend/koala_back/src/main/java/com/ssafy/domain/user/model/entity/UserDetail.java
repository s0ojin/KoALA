package com.ssafy.domain.user.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Setter
@Getter
@Table(name = "user_details")
@NoArgsConstructor(access = PROTECTED)
public class UserDetail {

    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_introduce")
    private String userIntroduce;

    @Column(name = "org_name")
    private String orgName;

}
