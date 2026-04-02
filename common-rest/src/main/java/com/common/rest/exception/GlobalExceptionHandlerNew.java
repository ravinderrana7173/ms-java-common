package com.common.rest.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.HttpStatus;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloud.api.common.exception.ForbiddenException;
import com.cloud.api.common.exception.RequestValidationException;
import com.common.rest.response.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandlerNew {

	@ExceptionHandler({ GenericException.class })
	public ResponseEntity<ErrorResponse> handleBadRequest(GenericException br) {
		log.info("GlobalExceptionHandlerNew->[handleBadRequest] Start");
		String errorReason = br.getErrorReason();
		String errorMessage = br.getErrorMessage();
		HttpStatusCode code = br.getCode();
		String errorCode = br.getErrorCode();
		String referenceError = br.getReferenceError();
		ErrorResponse errorResponse = new ErrorResponse(errorReason, errorMessage, errorCode, referenceError);
		log.info("GlobalExceptionHandlerNew->[handleBadRequest] End");
		return ResponseEntity.status(Integer.valueOf(errorCode)).body(errorResponse);

	}


	@ExceptionHandler({ ForbiddenException.class })
	public ResponseEntity<ErrorResponse> handleBadRequest(ForbiddenException br) {
		log.info("GlobalExceptionHandlerNew->[handleBadRequest] Start");
		String errorReason = "error";
		String errorMessage = br.getMessage();

		HttpStatusCode code = HttpStatusCode.valueOf(HttpStatus.SC_FORBIDDEN);
		String errorCode = String.valueOf(HttpStatus.SC_FORBIDDEN);
		// String referenceError = br.getReferenceError();
		ErrorResponse errorResponse = new ErrorResponse(errorReason, errorMessage, errorCode, null);
		log.info("GlobalExceptionHandlerNew->[handleBadRequest] End");
		return ResponseEntity.status(code).body(errorResponse);

	}

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException nfx) {
		log.info("GlobalExceptionHandlerNew->[handleNotFoundException] Start");
		String errorReason = "error";
		String errorMessage = nfx.getMessage();
		HttpStatusCode code = HttpStatusCode.valueOf(HttpStatus.SC_NOT_FOUND);
		String errorCode = String.valueOf(code.value());
		String referenceError = null;
		ErrorResponse errorResponse = new ErrorResponse(errorReason, errorMessage, errorCode, referenceError);
		log.info("GlobalExceptionHandlerNew->[handleNotFoundException] End");
		return ResponseEntity.status(code).body(errorResponse);

	}

	@ExceptionHandler({ InternalServerException.class })
	public ResponseEntity<ErrorResponse> handleInternalServerException(InternalServerException sx) {
		log.info("GlobalExceptionHandlerNew->[handleInternalServerException] Start");
		String errorReason = sx.getErrorReason();
		String errorMessage = sx.getErrorMessage();
		HttpStatusCode code = sx.getCode();
		String errorCode = String.valueOf(sx.getCode().value());
		String referenceError = sx.getReferenceError();
		ErrorResponse errorResponse = new ErrorResponse(errorReason, errorMessage, errorCode, referenceError);
		log.info("GlobalExceptionHandlerNew->[handleInternalServerException] End");
		return ResponseEntity.status(code).body(errorResponse);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
		log.info("GlobalExceptionHandlerNew->[handleValidationErrors] Start");
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());

//        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
		String errorReason = "Error";
		String errorMessage = errors.get(0);
		HttpStatusCode code = HttpStatusCode.valueOf(400);
		String errorCode = "InvalidBody";
		String referenceError = "";
		ErrorResponse errorResponse = new ErrorResponse(errorReason, errorMessage, errorCode, referenceError);
		log.info("GlobalExceptionHandlerNew->[handleValidationErrors] End");
		return ResponseEntity.status(code).body(errorResponse);

	}

	private Map<String, List<String>> getErrorsMap(List<String> errors) {
		log.info("GlobalExceptionHandlerNew->[getErrorsMap] Start");
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		log.info("GlobalExceptionHandlerNew->[getErrorsMap] End");
		return errorResponse;
	}

	@ExceptionHandler({ UnAuthorizedUserFoundException.class })
	public ResponseEntity<ErrorResponse> unAuthorizedUserFoundException(UnAuthorizedUserFoundException unu) {
		log.info("GlobalExceptionHandlerNew->[unAuthorizedUserFoundException] Start");
		String errorReason = org.springframework.http.HttpStatus.UNAUTHORIZED.getReasonPhrase();
		String errorMessage = null;
		if (unu.getErrorMessage() != null) {
			errorMessage = unu.getErrorMessage().get("error-message");
		}
		HttpStatusCode code = unu.getCode();
		String errorCode = unu.getErrorCode();
		String referenceError = unu.getReferenceError();
		ErrorResponse errorResponse = new ErrorResponse(errorReason, errorMessage, errorCode, referenceError);
		log.info("GlobalExceptionHandlerNew->[unAuthorizedUserFoundException] End");
		return ResponseEntity.status(code).body(errorResponse);

	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorResponse> handleMissingParams(MissingServletRequestParameterException ex) {
		log.info("GlobalExceptionHandlerNew->[handleMissingParams] Start");
		String name = ex.getParameterName();
		String errorReason = org.springframework.http.HttpStatus.BAD_REQUEST.getReasonPhrase();
		String errorMessage = name + " parameter is mandatory";
		HttpStatusCode code = ex.getStatusCode();
		String errorCode = String.valueOf(code.value());
		String referenceError = "";
		ErrorResponse errorResponse = new ErrorResponse(errorReason, errorMessage, errorCode, referenceError);
		log.info("GlobalExceptionHandlerNew->[handleMissingParams] End");
		return ResponseEntity.status(code).body(errorResponse);
	}

}
