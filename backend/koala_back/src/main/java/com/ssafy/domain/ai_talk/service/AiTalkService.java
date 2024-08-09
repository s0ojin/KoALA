package com.ssafy.domain.ai_talk.service;

import com.ssafy.domain.ai_talk.dto.request.AiTalkRequest;
import com.ssafy.domain.ai_talk.dto.request.AiTalkSituationRequest;
import com.ssafy.domain.ai_talk.dto.response.AiTalkFinishResponse;
import com.ssafy.domain.ai_talk.dto.response.AiTalkResponse;

public interface AiTalkService {
	AiTalkResponse setSituation(AiTalkSituationRequest aiTalkSituationRequest);

	AiTalkResponse getAIResponse(AiTalkRequest aiTalkRequest);

	AiTalkFinishResponse finishAIResponse();
}
