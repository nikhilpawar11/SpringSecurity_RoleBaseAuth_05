package com.lcwd.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseMessage> handleGlobalException(ResourceNotFoundException ex){
		
		ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<>(apiResponseMessage, HttpStatus.NOT_FOUND);
		
	}

}
