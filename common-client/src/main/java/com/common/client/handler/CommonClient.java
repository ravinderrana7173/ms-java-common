package com.common.client.handler;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.common.api.constant.CommonConstant;
import com.common.api.model.City;
import com.common.api.model.Country;
import com.common.api.model.States;
import com.common.client.config.CommonClientConfig;

import java.util.List;

/**
 * The Interface ImTemplate.
 */
@FeignClient(name = "CommonClient", url = "${common.base.url}", configuration = CommonClientConfig.class)
public interface CommonClient {

	/**
	 * Gets the all states.
	 *
	 * @param countryCode        the country code
	 * @param authorizationToken the authorization token
	 * @param correlationID      the correlation ID
	 * @return the all states
	 */
	@RequestMapping(value = CommonConstant.RequestUrl.STATES_URL, method = RequestMethod.GET)
	public List<States> getAllStates(
			@RequestParam(value = CommonConstant.RequestParam.COUNTRY_CODE, required = false) String countryCode,
			@RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
			@RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID);

	/**
	 * Gets the all country.
	 *
	 * @param authorizationToken the authorization token
	 * @param correlationID      the correlation ID
	 * @return the all country
	 */
	@RequestMapping(value = CommonConstant.RequestUrl.COUNTRY_URL, method = RequestMethod.GET)
	public List<Country> getAllCountry(@RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
			@RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID);
	
	
    /**
     * Gets the country name by code.
     *
     * @param countryCode the country code
     * @param authorizationToken the authorization token
     * @param correlationID the correlation ID
     * @return the country name by code
     */
    @GetMapping(value = CommonConstant.RequestUrl.COUNTRY_NAME_URL)
    public Country getCountryNameByCode(@RequestParam(
            value = CommonConstant.RequestParam.COUNTRY_CODE, required = false) String countryCode,
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID);

    
    
    /**
     * Gets the state name by code.
     *
     * @param countryCode the country code
     * @param stateCode the state code
     * @param authorizationToken the authorization token
     * @param correlationID the correlation ID
     * @return the state name by code
     */
    @GetMapping(value = CommonConstant.RequestUrl.STATE_NAME_URL)
    public States getStateNameByCode(
            @RequestParam(value = CommonConstant.RequestParam.COUNTRY_CODE, required = false) String countryCode,
            @RequestParam(value = CommonConstant.RequestParam.STATE_CODE, required = false) String stateCode,
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID);
    
    /**
     * Gets the city name by id.
     *
     * @param countryCode the country code
     * @param stateCode the state code
     * @param cityId the city id
     * @param authorizationToken the authorization token
     * @param correlationID the correlation ID
     * @return the city name by id
     */
    @GetMapping(value = CommonConstant.RequestUrl.CITY_NAME_URL)
    public City getCityNameById(
            @RequestParam(value = CommonConstant.RequestParam.COUNTRY_CODE, required = false) String countryCode,
            @RequestParam(value = CommonConstant.RequestParam.STATE_CODE, required = false) String stateCode,
            @RequestParam(value = CommonConstant.RequestParam.CITY_ID, required = false) String cityId,
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID);
    
    /**
     * @param countryCode
     * @param stateCode
     * @param cityName
     * @param authorizationToken
     * @param correlationID
     * @return
     */
    @GetMapping(value = CommonConstant.RequestUrl.CITY_URLS)
    public City getCityDetail(
            @RequestParam(value = CommonConstant.RequestParam.COUNTRY_CODE,
                    required = false) String countryCode,
            @RequestParam(value = CommonConstant.RequestParam.STATE_CODE,
                    required = false) String stateCode,
            @RequestParam(value = CommonConstant.RequestParam.CITY_NAME,
                    required = false) String cityName,
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID);

}
