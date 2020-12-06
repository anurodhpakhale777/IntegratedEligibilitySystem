package com.jrtp.ies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IESExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public String handleCommonException(Exception exception) {
		exception.printStackTrace();
		return exception.getMessage();
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleSsnCreationException(RuntimeException exception) {
		ResponseEntity<?> responseEnt = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return responseEnt;
	}
}
