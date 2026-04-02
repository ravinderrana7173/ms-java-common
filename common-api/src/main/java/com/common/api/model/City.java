package com.common.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class City.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    /** The name. */
    @JsonProperty("name")
    private String name;


    /** The code. */
    @JsonProperty("state_code")
    private String stateCode;

    /** The code. */
    @JsonProperty("country_code")
    private String countryCode;
    
    /** The cityID. */
    @JsonProperty("city_id")
    private Long cityID;
    
    



    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the state code.
     *
     * @return the state code
     */
    public String getStateCode() {
        return stateCode;
    }


    /**
     * Sets the state code.
     *
     * @param stateCode the new state code
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }


    /**
     * Gets the country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the country code.
     *
     * @param countryCode the new country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


	public Long getCityID() {
		return cityID;
	}


	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}



}
