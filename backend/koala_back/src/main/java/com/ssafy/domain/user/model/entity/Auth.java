package com.ssafy.domain.user.model.entity;

import static jakarta.persistence.FetchType.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
	private final List<User> users = new ArrayList<>();

	public Auth(String authName) {
		this.authName = authName;
	}

}
