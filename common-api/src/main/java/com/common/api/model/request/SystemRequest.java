package com.common.api.model.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

/**
 * Instantiates a new system request.
 */
@Data

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemRequest {
    
    /** The name. */
    @JsonProperty("name")
    private String name;

    /** The description. */
    @JsonProperty("description")
    private String description;

    /** The capabilities. */
    @JsonProperty("capabilities")
    private List<String> capabilityCodes;

}
