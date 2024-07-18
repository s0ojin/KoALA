package com.ssafy.core.koala.model.entity;

import com.ssafy.core.user.model.entity.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "koala")
public class Koala {

    @Id
    @GeneratedValue
    @Column(name = "koala_id")
    private Long koalaId;

    @OneToOne(mappedBy = "koala")
    private User user;

    @Column(name = "koala_name")
    private String koalaName;
    @Column(name = "koala_level")
    private Integer koalaLevel;
    @Column(name = "koala_exp")
    private Integer koalaExp;
    @Column(name = "koala_type")
    private Integer koalaType;
    @Column(name = "koala_created_at")
    private Date koalaCreatedAt;

}
