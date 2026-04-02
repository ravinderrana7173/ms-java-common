package com.common.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * 
 * This is ErrorResponse class.
 */
@Data
@JsonPropertyOrder({ "reason", "message", "referenceError", "code"})
public class ErrorResponse{

	@JsonProperty("reason")
	private String errorReason;
	
	@JsonProperty("message")
	private String errorMessage;
	
	@JsonProperty("code")
	private String errorCode;
	
	//private HttpStatusCode code;

	@JsonProperty("referenceError")
	private String referenceError;
	
	public ErrorResponse() {
		 
	}

	public ErrorResponse(String errorReason,String errorMessage,String errorCode, String referenceError) {
		
		this.errorReason = errorReason;
		this.errorMessage = errorMessage;
		//this.code = code;
		this.errorCode = errorCode;
		this.referenceError = referenceError;
	}

}
