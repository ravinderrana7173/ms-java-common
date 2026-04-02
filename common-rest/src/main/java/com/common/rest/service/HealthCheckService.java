package com.common.rest.service;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.rest.common.DatabaseDetails;
import com.common.rest.common.HealthCheckProperties;
import com.common.rest.constant.HealthCheckStatus;
import com.common.rest.response.HealthCheckInfoResponse;

public abstract class HealthCheckService {
	private static final Logger _log = LoggerFactory.getLogger(HealthCheckService.class);
	protected HealthCheckProperties healthCheckProperties;

	public HealthCheckService(final HealthCheckProperties healthCheckProperties) {
		this.healthCheckProperties = healthCheckProperties;
	}

	public abstract HealthCheckInfoResponse getHealthCheckInfo();

	public HealthCheckInfoResponse getHealthCheckDefaultObject() {
		HealthCheckInfoResponse healthCheckresponse = new HealthCheckInfoResponse();
		healthCheckresponse.setName(this.healthCheckProperties.appName);
		healthCheckresponse.setVersion(this.healthCheckProperties.appVersion);
		if (this.healthCheckProperties.includeAmqp) {
			healthCheckresponse.setRabbitmqstate(HealthCheckStatus.DOWN.toString());
		} else {
			healthCheckresponse.setRabbitmqstate((String) null);
		}

		if (this.healthCheckProperties.includeDb) {
			DatabaseDetails databaseDetails = new DatabaseDetails();
			databaseDetails.setState(HealthCheckStatus.DOWN.toString());
			healthCheckresponse.setDatabaseDetails(databaseDetails);
		} else {
			healthCheckresponse.setDatabaseDetails((DatabaseDetails) null);
		}

		try {
			healthCheckresponse.setServicehost(InetAddress.getLocalHost().getHostName());
			_log.info("[getHealthCheckDefaultObject] Service_host is " + InetAddress.getLocalHost().getHostName());
		} catch (Throwable var5) {
			_log.error("[getHealthCheckDefaultObject] - Exception: " + var5.getMessage(), var5);
		} finally {
			;
		}

		return healthCheckresponse;
	}
}
