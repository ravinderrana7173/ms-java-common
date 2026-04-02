package com.common.rest.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.common.util.ValidatorUtil;
import com.common.rest.common.DatabaseDetails;
import com.common.rest.common.HealthCheckProperties;
import com.common.rest.constant.HealthCheckStatus;
import com.common.rest.repository.VersionRepository;
import com.common.rest.response.HealthCheckInfoResponse;
import com.common.rest.service.HealthCheckService;

@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
@Service
public class HealthCheckDatabaseServiceImpl extends HealthCheckService {
	private static final Logger _log = LoggerFactory.getLogger(HealthCheckDatabaseServiceImpl.class);

	@Autowired
	private VersionRepository versionRepository;

	public HealthCheckDatabaseServiceImpl(final HealthCheckProperties healthCheckProperties) {
		super(healthCheckProperties);
	}

	public HealthCheckInfoResponse getHealthCheckInfo() {
		HealthCheckInfoResponse healthCheckresponse = this.getHealthCheckDefaultObject();

		try {
			if (this.healthCheckProperties.includeDb) {
				String versionNumber = this.versionRepository.getLatestVersion();
				Map<String, String> migrationsversions = new HashMap();
				DatabaseDetails dbModel = healthCheckresponse.getDatabaseDetails();
				
				if (ValidatorUtil.isNull(versionNumber)) 
					versionNumber = HealthCheckStatus.UP.toString();
				
				if (!ValidatorUtil.isNull(versionNumber)) {
					migrationsversions.put(this.healthCheckProperties.appNameAlias, versionNumber);
					dbModel.setMigrationsversions(migrationsversions);
					dbModel.setState(HealthCheckStatus.UP.toString());
				} else {
					dbModel.setState(HealthCheckStatus.DOWN.toString());
				}
			}
		} catch (Exception var7) {
			_log.error("[getHealthCheckInfo] - Exception: " + var7.getMessage(), var7);
		} finally {
			;
		}

		return healthCheckresponse;
	}
}
