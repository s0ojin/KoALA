package com.ssafy.domain.sentence.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SentenceTestResponse {
    @JsonProperty("origin_text")
    private String originText;
    @JsonProperty("user_text")
    private String userText;
    @JsonProperty("result_tag")
    private String resultTag;

    private boolean correct;
}
