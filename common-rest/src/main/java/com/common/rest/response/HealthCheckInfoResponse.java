package com.common.rest.response;

import com.common.rest.common.DatabaseDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "name", "version", "service_host", "rabbitmq_state", "mysql" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthCheckInfoResponse {
	private String name;
	private String version;
	private String servicehost;
	@JsonProperty("rabbitmq_state")
	private String rabbitmqstate;
	@JsonProperty("mysql")
	private DatabaseDetails databaseDetails;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public String getServicehost() {
		return this.servicehost;
	}

	public void setServicehost(final String servicehost) {
		this.servicehost = servicehost;
	}

	public String getRabbitmqstate() {
		return this.rabbitmqstate;
	}

	public void setRabbitmqstate(final String rabbitmqstate) {
		this.rabbitmqstate = rabbitmqstate;
	}

	public DatabaseDetails getDatabaseDetails() {
		return this.databaseDetails;
	}

	public void setDatabaseDetails(final DatabaseDetails databaseDetails) {
		this.databaseDetails = databaseDetails;
	}
}
