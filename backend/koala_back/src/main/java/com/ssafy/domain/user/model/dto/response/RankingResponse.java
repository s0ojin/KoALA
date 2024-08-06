package com.ssafy.domain.user.model.dto.response;

import static lombok.AccessLevel.*;

import com.ssafy.domain.user.model.entity.Ranking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class RankingResponse {

	private Long userId;
	private String nickname;
	private Integer ranking;

	@Builder
	public static RankingResponse toDto(Ranking ranking) {
		return RankingResponse.builder()
			.userId(ranking.getUserId())
			.nickname(ranking.getUser().getNickname())
			.ranking(ranking.getRanking())
			.build();
	}

}
