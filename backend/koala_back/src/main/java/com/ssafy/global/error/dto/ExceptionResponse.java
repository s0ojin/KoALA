package com.ssafy.global.error.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExceptionResponse {

    private String message;
    private String code;
    private String status;

    public ExceptionResponse(String message, String code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

}
