package com.ssafy.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ssafy.global.error.exception.TokenException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TokenException.class)
	public ResponseEntity<String> handleTokenException(TokenException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
	}

}
