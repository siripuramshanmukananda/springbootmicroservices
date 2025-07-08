package com.order.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestOrderExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(OrderServiceException.class)
	public ResponseEntity<ErrorResponse> handleOrderServiceException(OrderServiceException exception){
		ErrorResponse error = new ErrorResponse(exception.getMessage(), exception.getErrorCode());
	
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
