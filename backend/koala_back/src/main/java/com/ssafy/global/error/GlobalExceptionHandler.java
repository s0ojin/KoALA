package com.ssafy.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssafy.global.error.dto.ExceptionResponse;
import com.ssafy.global.error.exception.KoalaApplicationException;
import com.ssafy.global.error.exception.KoalaException;
import com.ssafy.global.error.exception.UserException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ExceptionResponse> handleUserException(UserException ex) {
		ExceptionResponse response = ExceptionResponse.builder()
			.message(ex.getMessage())
			.status(HttpStatus.BAD_REQUEST.value())
			.build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(KoalaException.class)
	public ResponseEntity<ExceptionResponse> handleKoalaException(KoalaException ex) {
		ExceptionResponse response = ExceptionResponse.builder()
			.message(ex.getMessage())
			.status(HttpStatus.BAD_REQUEST.value())
			.build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(KoalaApplicationException.class)
	public ResponseEntity<ExceptionResponse> handleKoalaApplicationException(KoalaApplicationException ex) {
		ExceptionResponse response = ExceptionResponse.builder()
			.message(ex.getMessage())
			.status(HttpStatus.BAD_REQUEST.value())
			.build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleException(Exception ex) {
		ExceptionResponse response = ExceptionResponse.builder()
			.message(ex.getMessage())
			.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
			.build();
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		ExceptionResponse response = ExceptionResponse.builder()
			.message(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage())
			.status(HttpStatus.BAD_REQUEST.value())
			.build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionResponse> handleConstraintViolationException(ConstraintViolationException ex) {
		ExceptionResponse response = ExceptionResponse.builder()
			.message(ex.getMessage())
			.status(HttpStatus.BAD_REQUEST.value())
			.build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
