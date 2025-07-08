package com.order.exception.decoder;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.exceptionhandler.ErrorResponse;
import com.order.exceptionhandler.OrderServiceException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			return new OrderServiceException(errorResponse.getMessage(), errorResponse.getErrorCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new OrderServiceException("ServiceInternalException", "SERVICE_EXCEPTION");
	}

}
