package com.ssafy.domain.user.model.dto.response;

import static lombok.AccessLevel.*;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
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
