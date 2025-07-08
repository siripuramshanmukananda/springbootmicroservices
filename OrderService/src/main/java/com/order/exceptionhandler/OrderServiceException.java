package com.order.exceptionhandler;

public class OrderServiceException extends Exception {

	private String errorCode;
	
	public OrderServiceException(String message, String errorCode) {
		super(message);
		this.setErrorCode(errorCode);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
