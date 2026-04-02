package com.common.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * 
 * This is ErrorResponse class.
 */
@Data
@JsonPropertyOrder({ "reason", "message", "referenceError", "code"})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

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
