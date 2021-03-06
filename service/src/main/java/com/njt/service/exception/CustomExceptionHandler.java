package com.njt.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(NotFoundException exception) {
		CustomErrorResponse error = new CustomErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exception.getMessage(),
											System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception exception) {
		CustomErrorResponse error = new CustomErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exception.getMessage(),
											System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
