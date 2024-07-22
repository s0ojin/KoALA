package com.ssafy.domain.koala.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "koala")
@NoArgsConstructor(access = PROTECTED)
public class Koala {

    @Id @GeneratedValue
    @Column(name = "koala_id")
    private Long koalaId;

    @OneToOne(mappedBy = "koala", fetch = LAZY)
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
    private LocalDateTime koalaCreatedAt;

}
