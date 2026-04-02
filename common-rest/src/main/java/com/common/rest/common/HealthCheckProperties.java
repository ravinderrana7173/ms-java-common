package com.common.rest.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "classpath:health-check-config.properties" })
public class HealthCheckProperties {
	@Value("${healthcheck.version.table.name}")
	public String versionTableName;
	@Value("${healthcheck.app.name.alias}")
	public String appNameAlias;
	@Value("${healthcheck.app.name}")
	public String appName;
	@Value("${healthcheck.app.version}")
	public String appVersion;
	@Value("${healthcheck.include.db}")
	public Boolean includeDb;
	@Value("${healthcheck.include.amqp}")
	public Boolean includeAmqp;
}
