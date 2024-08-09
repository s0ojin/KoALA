package com.ssafy.domain.ai_talk.service;

import com.ssafy.domain.ai_talk.dto.request.AITalkRequest;
import com.ssafy.domain.ai_talk.dto.request.AITalkSituationRequest;
import com.ssafy.domain.ai_talk.dto.response.AITalkResponse;

public interface AITalkService {
	AITalkResponse setSituation(AITalkSituationRequest AITalkSituationRequest);

	AITalkResponse getAIResponse(AITalkRequest AITalkRequest);

	void finishAIResponse();
}
