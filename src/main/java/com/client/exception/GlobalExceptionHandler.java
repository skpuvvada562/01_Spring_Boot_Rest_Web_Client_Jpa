package com.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=NoDataFoundException.class)
	public ResponseEntity<String> noDataFoundException(NoDataFoundException ndf){
		
		String message=ndf.getMessage();
		
		return new ResponseEntity<String>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
