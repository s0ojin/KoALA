package com.ssafy.global.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssafy.global.error.dto.ExceptionResponse;
import com.ssafy.global.error.exception.KoalaApplicationException;
import com.ssafy.global.error.exception.UserException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ExceptionResponse> handleKoalaApplicationException(final KoalaApplicationException e,
		final int status) {
		final ExceptionResponse errorResponse = ExceptionResponse.builder()
			.message(e.getMessage())
			.status(status)
			.build();
		return ResponseEntity.status(status).body(errorResponse);
	}

}
