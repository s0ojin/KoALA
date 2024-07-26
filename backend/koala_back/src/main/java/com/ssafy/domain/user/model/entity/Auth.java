package com.ssafy.domain.user.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "auth")
public class Auth {

    @Id
    @GeneratedValue
    @Column(name = "auth_id")
    private Long authId;

    @Column(name = "auth_name")
    private String authName = "user";

    @OneToMany(mappedBy = "auth", fetch = LAZY)
    private List<User> users = new ArrayList<>();

    public Auth(String authName) {
        this.authName = authName;
    }

}
