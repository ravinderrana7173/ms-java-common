/*package com.common.rest.constant;

import java.util.UUID;
import org.springframework.http.HttpHeaders;
import com.common.api.constant.CommonConstant;

*//**
 * The Class AuthenticationMockData.
 *//*
public class AuthenticationMockData {

	*//** The Constant authorization. *//*
	public static final String authorization = UUID.randomUUID().toString();

	*//** The Constant basicauth. *//*
	public static final String basicauth = UUID.randomUUID().toString();

	*//** The Constant correlationid. *//*
	public static final String correlationid = UUID.randomUUID().toString();

	*//** The Constant userId. *//*
	public static final long userId = 44;

	*//**
	 * Gets the valid http headers.
	 *
	 * @return the valid http headers
	 *//*
	public static HttpHeaders getValidHttpHeaders() {
		HttpHeaders validHttpHeaders = new HttpHeaders();
		validHttpHeaders.add(CommonConstant.Header.AUTHORIZATION, authorization);
		validHttpHeaders.add(CommonConstant.Header.CORRELATION_ID, correlationid);
		validHttpHeaders.add("Basic", basicauth);
		return validHttpHeaders;
	}

}
*/