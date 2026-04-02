package com.common.api.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Instantiates a new system response.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemResponse {

	/** The name. */
	@JsonProperty("name")
	private String name;

	/** The uuid. */
	@JsonProperty("uuid")
	private String uuid;

	/** The description. */
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("system_code")
	private String systemCode;
	
	@JsonProperty("is_simulation")
	private Boolean isSimulation;
	
	/** The capabilities. */
	@JsonProperty("capabilities")
	private List<String> capabilities;
	
	@JsonProperty("capabilities_details")
	List<CapabilityDetailsResponse> CapabilityDetailsResponseList;

	/** The logo. */
	@JsonProperty("logo")
	private String logo;

}
