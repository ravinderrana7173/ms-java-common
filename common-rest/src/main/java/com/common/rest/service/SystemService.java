package com.common.rest.service;

import java.util.List;

import com.common.api.model.request.SystemRequest;
import com.common.api.model.response.CapabilityResponse;
import com.common.api.model.response.SystemResponse;

/**
 * The Interface SystemService.
 */
public interface SystemService {

	/**
	 * Gets the all.
	 *
	 * @param systemName     the system name
	 * @param capabilityCode the capability code
	 * @return the all
	 */
	List<SystemResponse> getAll(String systemName, String capabilityCode);

	/**
	 * Gets the by uuid.
	 *
	 * @param systemUuid the system uuid
	 * @return the by uuid
	 */
	SystemResponse getByUuid(String systemUuid);

	/**
	 * Creates the.
	 *
	 * @param systemRequest the system request
	 * @return the system response
	 */
	SystemResponse create(SystemRequest systemRequest);

	/**
	 * Update.
	 *
	 * @param systemRequest the system request
	 * @param systemUuid    the system uuid
	 * @return the system response
	 */
	SystemResponse update(SystemRequest systemRequest, String systemUuid);

	/**
	 * Delete.
	 *
	 * @param systemUuid the system uuid
	 */
	void delete(String systemUuid);

	/**
	 * Gets the all capability.
	 *
	 * @return the all capability
	 */
	List<CapabilityResponse> getAllCapability();

}
