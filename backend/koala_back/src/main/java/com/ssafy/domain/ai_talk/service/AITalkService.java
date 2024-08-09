package com.ssafy.domain.ai_talk.service;

import com.ssafy.domain.ai_talk.dto.request.AITalkRequest;
import com.ssafy.domain.ai_talk.dto.request.AITalkSituationRequest;
import com.ssafy.domain.ai_talk.dto.response.AITalkFinishResponse;
import com.ssafy.domain.ai_talk.dto.response.AITalkResponse;

public interface AITalkService {
	AITalkResponse setSituation(AITalkSituationRequest aiTalkSituationRequest);

	AITalkResponse getAIResponse(AITalkRequest aiTalkRequest);

	AITalkFinishResponse finishAIResponse();
}
