package com.common.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.common.util.ValidatorUtil;
import com.common.rest.common.HealthCheckProperties;
import com.common.rest.constant.HealthCheckStatus;
import com.common.rest.response.HealthCheckInfoResponse;
import com.common.rest.service.HealthCheckService;

@RestController
@RequestMapping(path = { "/health-check" }, produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthCheckController {

	private static final Logger _log = LoggerFactory.getLogger(HealthCheckController.class);
	private HealthCheckService healthCheckService;
	private HealthCheckProperties healthCheckProperties;

	public HealthCheckController(final HealthCheckService healthCheckService,
			final HealthCheckProperties healthCheckProperties) {
		this.healthCheckService = healthCheckService;
		this.healthCheckProperties = healthCheckProperties;
	}

	@GetMapping()
	public ResponseEntity<?> healthCheck() {
		_log.info("[Health Check] starts");
		HttpStatus returnHttpCode = HttpStatus.OK;
		HealthCheckInfoResponse healthCheckInfoResponse = null;

		try {
			healthCheckInfoResponse = this.healthCheckService.getHealthCheckInfo();
			ResponseEntity.ok(healthCheckInfoResponse);
		} catch (Exception var6) {
			_log.error(" [Health Check] - Exception: " + var6.getMessage(), var6);
			returnHttpCode = HttpStatus.INTERNAL_SERVER_ERROR;
			ResponseEntity.ok(returnHttpCode);
		} finally {
			;
		}

		_log.info("[Health Check] - End");
		if (ValidatorUtil.isNull(healthCheckInfoResponse)
				|| this.healthCheckProperties.includeDb && !ValidatorUtil.isNull(healthCheckInfoResponse)
						&& healthCheckInfoResponse.getDatabaseDetails().getState()
								.equalsIgnoreCase(HealthCheckStatus.DOWN.toString())
				|| this.healthCheckProperties.includeAmqp && !ValidatorUtil.isNull(healthCheckInfoResponse)
						&& healthCheckInfoResponse.getRabbitmqstate()
								.equalsIgnoreCase(HealthCheckStatus.DOWN.toString())) {
			returnHttpCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity(healthCheckInfoResponse, returnHttpCode);
	}
}
