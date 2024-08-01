package com.ssafy.domain.chat.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafy.domain.chat.dto.Message;

import java.util.List;

public class GPTResponse {
    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public static class Choice {
        private Message message;
        @JsonCreator
        public Choice(@JsonProperty("message") Message message) {
            this.message = message;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }

    /*
    {
    "id": "chatcmpl-8tqujCfSEroJwUPlY6ABf0T8c1NgD",
    "object": "chat.completion",
    "created": 1708322133,
    "model": "gpt-3.5-turbo-0125",
    "choices": [
        {
            "index": 0,
            "message": {
                "role": "assistant",
                "content": "{\n    \"error\": \"There was no World Series held in 2020 due to the COVID-19 pandemic.\"\n}"
            },
            "logprobs": null,
            "finish_reason": "stop"
        }
    ],
    "usage": {
        "prompt_tokens": 31,
        "completion_tokens": 25,
        "total_tokens": 56
    },
    "system_fingerprint": "fp_6dd124df95"
}
     */

}
