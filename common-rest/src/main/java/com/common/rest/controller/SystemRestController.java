package com.common.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.common.annotation.Permissions;
import com.common.api.constant.CommonConstant;
import com.common.api.model.request.SystemRequest;
import com.common.api.model.response.CapabilityResponse;
import com.common.api.model.response.SystemResponse;
import com.common.rest.service.SystemService;
import com.common.rest.validator.SystemValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = CommonConstant.RequestUrl.System.SYSTEM_ROOT_CONTEXT_URL, produces = MediaType.APPLICATION_JSON_VALUE, headers = {
		CommonConstant.Header.CORRELATION_ID, CommonConstant.Header.AUTHORIZATION })
public class SystemRestController {

	/** The system service. */
	@Autowired
	private SystemService systemService;

	/** The system validator. */
	@Autowired
	private SystemValidator systemValidator;

	
	/**
	 * @return
	 */
	@GetMapping(value = CommonConstant.RequestUrl.System.SYSTEM_CAPABILITIES_URL)
	@Permissions(values = { CommonConstant.PermissionConstant.VIEW_SYSTEM_CAPABILITIES })
	public List<CapabilityResponse> getAllCapability() {
	//	log.info("[getAllCapability] fetching all capability ");
		List<CapabilityResponse> capabilities = systemService.getAllCapability();
		return capabilities;
	}

	
	/**
	 * @param systemRequest
	 * @return
	 */
	@PostMapping
	@Permissions(values = { CommonConstant.PermissionConstant.REGISTER_SYSTEM })
	@ResponseStatus(HttpStatus.CREATED)
	public SystemResponse create(@RequestBody final SystemRequest systemRequest) {
	//	log.info("[create] Validating System rquest");
		systemValidator.validateSystemRequest(systemRequest);
	//	log.info("[create] registering new system");
		return systemService.create(systemRequest);
	}

	
	/**
	 * @param systemRequest
	 * @param systemUuid
	 * @return
	 */
	@PatchMapping(value = { CommonConstant.RequestUrl.System.SYSTEM_UUID_URL })
	@Permissions(values = { CommonConstant.PermissionConstant.UPDATE_SYSTEM })
	public SystemResponse update(@RequestBody final SystemRequest systemRequest,
			@PathVariable(value = "system_uuid") String systemUuid) {
	//	log.info("[update] Validating System rquest {}", systemUuid);
		systemValidator.validateUpdateSystemRequest(systemRequest, systemUuid);
	//	log.info("[update] Updating system {}", systemUuid);
		return systemService.update(systemRequest, systemUuid);
	}

	
	/**
	 * @param authorizationToken
	 * @param correlationID
	 * @param systemName
	 * @return
	 */
	@GetMapping
	@Permissions(values = { CommonConstant.PermissionConstant.VIEW_SYSTEM })
	public List<SystemResponse> getAll(@RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
			@RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID,
			@RequestParam(value = "name", required = false) String systemName,
			@RequestParam(name = "capability", required = false) String capabilityCode) {
	//	log.info("[getAll] getting all systemes with name{}", systemName);
		List<SystemResponse> systemList = systemService.getAll(systemName,capabilityCode);
		return systemList;
	}

	
	/**
	 * @param authorizationToken
	 * @param correlationID
	 * @param systemUuid
	 * @return
	 */
	@GetMapping(value = CommonConstant.RequestUrl.System.SYSTEM_UUID_URL)
	@Permissions(values = { CommonConstant.PermissionConstant.VIEW_SYSTEM })
	public SystemResponse getByUuid(@RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
			@RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID,
			@PathVariable(value = "system_uuid") String systemUuid) {
	//	log.info("[getByUuid] validating system uuid {}", systemUuid);
		systemValidator.validateSystemUuid(systemUuid);
	//	log.info("[getByUuid] fetching system by uuid {}", systemUuid);
		SystemResponse systemResponse = systemService.getByUuid(systemUuid);
		return systemResponse;
	}

	
	/**
	 * @param systemUuid
	 */
	@DeleteMapping(value = CommonConstant.RequestUrl.System.SYSTEM_UUID_URL)
	@Permissions(values = { CommonConstant.PermissionConstant.DELETE_SYSTEM })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "system_uuid") String systemUuid) {
	//	log.info("[delete] validating system uuid {}", systemUuid);
		systemValidator.validateSystemUuid(systemUuid);
	//	log.info("[delete] deleting system by uuid {}", systemUuid);
		systemService.delete(systemUuid);
	}

}
