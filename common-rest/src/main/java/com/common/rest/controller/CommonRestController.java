package com.common.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.common.annotation.Permissions;
import com.common.api.constant.CommonConstant;
import com.common.api.model.City;
import com.common.api.model.Country;
import com.common.api.model.States;
import com.common.rest.request.LocationRequest;
import com.common.rest.response.LocationResponse;
import com.common.rest.service.CommonService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * The Class CommonController.
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, headers = { CommonConstant.Header.CORRELATION_ID })
public class CommonRestController {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The common service. */
	@Autowired
	private CommonService commonService;

	
    /**
     * @param authorizationToken
     * @param correlationID
     * @return
     */
    @RequestMapping(value = CommonConstant.RequestUrl.COUNTRY_URL, method = RequestMethod.GET)
    @Permissions(values = {CommonConstant.PermissionConstant.GET_STATES})
    public List<Country> getAllCountry(
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID) {
        logger.info("[getAllCountry] -start");
        List<Country> countryListResponse = commonService.getAllCountry();
        logger.info("[getAllCountry]- end");
        return countryListResponse;
    }

	
    /**
     * @param authorizationToken
     * @param correlationID
     * @param countryCode
     * @return
     */
    @RequestMapping(value = CommonConstant.RequestUrl.STATES_URL, method = RequestMethod.GET)
    @Permissions(values = {CommonConstant.PermissionConstant.GET_COUNTRIES})
    public List<States> getAllStates(
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID,
            @RequestParam(value = CommonConstant.RequestParam.COUNTRY,
                    required = false) String countryCode) {
        logger.info("[getAllStates] start");
        List<States> statesResponse = commonService.getStates(countryCode);
        logger.info("[getAllStates] end");
        return statesResponse;
    }

	
    /**
     * @param authorizationToken
     * @param correlationID
     * @param stateCode
     * @param countryCode
     * @return
     */
    @RequestMapping(value = CommonConstant.RequestUrl.CITY_URL, method = RequestMethod.GET)
    @Permissions(values = {CommonConstant.PermissionConstant.GET_CITYS})
    public List<City> getAllCity(
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID,
            @RequestParam(value = CommonConstant.RequestParam.STATE,
                    required = false) String stateCode,
            @RequestParam(value = CommonConstant.RequestParam.COUNTRY,
                    required = false) String countryCode) {
        logger.info("[getAllCity] start");
        List<City> statesResponse = commonService.getCitys(stateCode, countryCode);
        logger.info("[getAllCity] end");
        return statesResponse;
    }

	
    /**
     * @param authorizationToken
     * @param correlationID
     * @param countryCode
     * @return
     */
    @GetMapping(value = CommonConstant.RequestUrl.COUNTRY_NAME_URL)
    @Permissions(values = {CommonConstant.PermissionConstant.GET_COUNTRIES})
    public Country getCountryNameByCode(
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID,
            @RequestParam(value = CommonConstant.RequestParam.COUNTRY_CODE,
                    required = false) String countryCode) {
        logger.info("[getCountryNameByCode] start");
        Country country = commonService.getCountryNameByCode(countryCode);
        logger.info("[getCountryNameByCode] end");
        return country;
    }

	
    /**
     * @param authorizationToken
     * @param correlationID
     * @param countryCode
     * @param stateCode
     * @return
     */
    @GetMapping(value = CommonConstant.RequestUrl.STATE_NAME_URL)
    @Permissions(values = {CommonConstant.PermissionConstant.GET_STATES})
    public States getStateNameByCode(
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID,
            @RequestParam(value = CommonConstant.RequestParam.COUNTRY_CODE,
                    required = false) String countryCode,
            @RequestParam(value = CommonConstant.RequestParam.STATE_CODE,
                    required = false) String stateCode) {
        logger.info("[getStateNameByCode] start");
        States states = commonService.getStateNameByCode(countryCode, stateCode);
        logger.info("[getStateNameByCode] end");
        return states;
    }
	
    
    /**
     * @param authorizationToken
     * @param correlationID
     * @param countryCode
     * @param stateCode
     * @param cityId
     * @return
     */
    @GetMapping(value = CommonConstant.RequestUrl.CITY_NAME_URL)
    @Permissions(values = {CommonConstant.PermissionConstant.GET_CITYS})
    public City getCityNameById(
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID,
            @RequestParam(value = CommonConstant.RequestParam.COUNTRY_CODE,
                    required = false) String countryCode,
            @RequestParam(value = CommonConstant.RequestParam.STATE_CODE,
                    required = false) String stateCode,
            @RequestParam(value = CommonConstant.RequestParam.CITY_ID,
                    required = false) String cityId) {
        logger.info("[getCityNameById] start");
        City city = commonService.getCityNameById(countryCode, stateCode, cityId);
        logger.info("[getCityNameById] end");
        return city;
    }
    
    /**
     * @param authorizationToken
     * @param correlationID
     * @param countryCode
     * @param stateCode
     * @param cityName
     * @return
     */
    @GetMapping(value = CommonConstant.RequestUrl.CITY_URLS)
    @Permissions(values = {CommonConstant.PermissionConstant.GET_CITYS})
    public City getCityDetail(
            @RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
            @RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID,
            @RequestParam(value = CommonConstant.RequestParam.COUNTRY_CODE,
                    required = false) String countryCode,
            @RequestParam(value = CommonConstant.RequestParam.STATE_CODE,
                    required = false) String stateCode,
            @RequestParam(value = CommonConstant.RequestParam.CITY_NAME,
                    required = false) String cityName) {
        logger.info("[getCityNameById] start");
        City city = commonService.getCityDetail(countryCode, stateCode, cityName);
        logger.info("[getCityNameById] end");
        return city;
    }
    
    @PostMapping(value = CommonConstant.RequestUrl.FETCH_LOCATION)
	@Operation(summary = "Fetch location details by country, state and city codes")
	public ResponseEntity<List<LocationResponse>> fetchLocations(
			@RequestHeader(CommonConstant.Header.AUTHORIZATION) String authorizationToken,
			@RequestHeader(CommonConstant.Header.CORRELATION_ID) String correlationID,
			@RequestBody List<LocationRequest> requestList) {

		logger.info("LocationController -> [fetchLocations] Start");

		List<LocationResponse> responseList = commonService.fetchLocations(authorizationToken, correlationID,
				requestList);

		logger.info("LocationController -> [fetchLocations] End");

		return ResponseEntity.ok(responseList);
	}
}
