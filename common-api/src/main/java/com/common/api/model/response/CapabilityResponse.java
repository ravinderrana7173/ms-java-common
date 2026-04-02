package com.common.api.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Instantiates a new capability response.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CapabilityResponse {

    /** The name. */
    @JsonProperty("name")
    private String name;

    /** The code. */
    @JsonProperty("code")
    private String code;

    /** The description. */
    @JsonProperty("description")
    private String description;

}
