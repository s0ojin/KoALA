package com.ssafy.domain.ai_talk.model.entity;

import static lombok.AccessLevel.*;

import com.ssafy.domain.ai_talk.model.dto.response.AiTalkSituationResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@Table(name = "ai_talk_situation")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class AiTalkSituation {
	@Id
	@GeneratedValue
	@Column(name = "situation_id")
	private Long situationId;

	@Column(name = "situation_title")
	private String situationTitle;

	@Column(name = "situation_detail")
	private String situationDetail;

	@Column(name = "situation_place")
	private String situationPlace;

	@Column(name = "ai_role")
	private String aiRole;

	@Column(name = "user_role")
	private String userRole;

	@Column(name = "situation_img_url")
	private String situationImgUrl;

	public static AiTalkSituationResponse toDto(AiTalkSituation aiTalkSituation){
		return AiTalkSituationResponse.builder()
			.situationId(aiTalkSituation.getSituationId())
			.situationPlace(aiTalkSituation.getSituationPlace())
			.situationTitle(aiTalkSituation.getSituationTitle())
			.situationDetail(aiTalkSituation.getSituationDetail())
			.situationImgUrl(aiTalkSituation.getSituationImgUrl())
			.build();
	}

}
