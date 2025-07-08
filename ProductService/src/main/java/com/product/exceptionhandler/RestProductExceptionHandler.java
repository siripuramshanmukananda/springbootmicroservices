package com.product.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestProductExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceException exception){
		ErrorResponse error = new ErrorResponse(exception.getMessage(), exception.getErrorCode());
	
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
