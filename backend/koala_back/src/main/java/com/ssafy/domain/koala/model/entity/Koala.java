package com.ssafy.domain.koala.model.entity;

import com.ssafy.domain.user.model.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "koala")
@NoArgsConstructor(access = PROTECTED)
public class Koala {

    @Id
    @GeneratedValue
    @Column(name = "koala_id")
    private Long koalaId;

    @OneToOne(mappedBy = "koala", fetch = LAZY)
    private User user;

    @Column(name = "koala_name", nullable = false)
    @ColumnDefault("코알라")
    private String koalaName;

    @Column(name = "koala_level", nullable = false)
    @ColumnDefault("1")
    private Integer koalaLevel;

    @Column(name = "koala_exp", nullable = false)
    @ColumnDefault("0")
    private Integer koalaExp;

    @Column(name = "koala_type", nullable = false)
    @ColumnDefault("1")
    private Integer koalaType;

    @Column(name = "koala_created_at", nullable = false)
    private LocalDateTime koalaCreatedAt = LocalDateTime.now();

}
