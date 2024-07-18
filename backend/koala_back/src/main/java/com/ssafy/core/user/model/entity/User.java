package com.ssafy.core.user.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class User {

    @Id
//    @GeneratedValue
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
    @Column(name = "koala_id")
    private Long koalaId;

    @Column(name = "user_level")
    private Integer userLevel;
    @Column(name = "user_created_at")
    private Date userCreatedAt;
}
