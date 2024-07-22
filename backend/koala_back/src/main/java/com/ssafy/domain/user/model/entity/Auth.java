package com.ssafy.domain.user.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Table(name = "auth")
public class Auth {

    @Id
    @GeneratedValue
    @Column(name = "auth_id")
    private Long authId;

    @OneToMany(mappedBy = "authId", cascade = ALL, fetch = LAZY)
    private List<User> users = new ArrayList<>();
}
