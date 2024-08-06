package com.ssafy.domain.user.model.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RankingWithMyRankResponse {

	List<RankingResponse> rankings;
	Integer myRank;

	@Builder
	public static RankingWithMyRankResponse toDto(List<RankingResponse> rankings, Integer myRank) {
		return RankingWithMyRankResponse.builder()
			.rankings(rankings)
			.myRank(myRank)
			.build();
	}

}
