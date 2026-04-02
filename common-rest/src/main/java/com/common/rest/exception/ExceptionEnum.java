package com.common.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {

	missingQueryParameter("missingQueryParameter"),

	missingQueryValue("missingQueryValue"),

	invalidQuery("invalidQuery"),

	invalidBody("invalidBody"),

	notFound("notFound"),

	internalError("internalError "),

	accessDenied("accessDenied");

	private final String name;

}
