package com.ssafy.domain.koala.model.entity;

import static com.ssafy.domain.koala.model.validation.KoalaValidation.*;
import static jakarta.persistence.FetchType.*;
import static lombok.AccessLevel.*;

import java.time.LocalDateTime;

import com.ssafy.domain.user.model.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@Table(name = "koala")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class Koala {

	@Id
	@GeneratedValue
	@Column(name = "koala_id")
	private Long koalaId;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Builder.Default
	@Column(name = "koala_name")
	private String koalaName = "코알라";

	@Builder.Default
	@Column(name = "koala_level")
	private Integer koalaLevel = 1;

	@Builder.Default
	@Column(name = "koala_exp")
	private Integer koalaExp = 0;

	@Builder.Default
	@Column(name = "koala_type")
	private Integer koalaType = 1;

	@Builder.Default
	@Column(name = "koala_created_at")
	private LocalDateTime koalaCreatedAt = LocalDateTime.now();

	@Builder
	public Koala(
		final User user,
		final String koalaName,
		final Integer koalaLevel,
		final Integer koalaExp,
		final Integer koalaType) {
		validate(koalaName, koalaLevel, koalaExp, koalaType);
		this.user = user;
		this.koalaName = koalaName;
		this.koalaLevel = koalaLevel;
		this.koalaExp = koalaExp;
	}

	public void updateKoalaName(final String koalaName) {
		validateKoalaName(koalaName);
		this.koalaName = koalaName;
	}

	// exp 100이면 level 2로 변경하고 exp 0으로 초기화
	public void increaseKoalaLevel() {
		validateKoalaLevel(koalaLevel);
		this.user.increaseUserLevel(10);
		this.koalaLevel++;
	}

	// increase 호출되면 1증가
	public void increaseKoalaExp() {
		validateKoalaExp(koalaExp);
		this.koalaExp++;
		if (koalaExp == 100) {
			increaseKoalaLevel();
			this.koalaExp = 0;
		}
	}

}
