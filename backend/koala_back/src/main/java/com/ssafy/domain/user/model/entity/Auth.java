package com.ssafy.domain.user.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
