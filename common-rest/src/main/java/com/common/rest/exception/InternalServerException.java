package com.common.rest.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatusCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternalServerException extends Exception implements Serializable {

	private static final long serialVersionUID = 3L;
	private final String errorMessage;
	private final HttpStatusCode code;
	private final ExceptionEnum errorCode;
	private final String errorReason;
	private final String referenceError;
	
	
	public InternalServerException(String errorReason, HttpStatusCode code,String errorMessage,ExceptionEnum errorcode,String referenceError) {
		this.errorMessage = errorMessage;
		this.code = code;
		this.errorCode = errorcode;
		this.errorReason = errorReason;
		this.referenceError = referenceError;
	}
}
