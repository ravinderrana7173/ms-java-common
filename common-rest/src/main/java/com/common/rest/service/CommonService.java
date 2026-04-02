package com.common.rest.service;

import java.util.List;

import com.common.api.model.City;
import com.common.api.model.Country;
import com.common.api.model.States;
import com.common.rest.request.LocationRequest;
import com.common.rest.response.LocationResponse;

/**
 * The Interface InventoryService.
 */
public interface CommonService {

	/**
	 * Gets the all country.
	 *
	 * @return the all country
	 */
	public List<Country> getAllCountry();

	
	/**
	 * @param countryCode
	 * @return
	 */
	public List<States> getStates(String countryCode);

	
	/**
	 * @param stateCode
	 * @param countryCode
	 * @return
	 */
	public List<City> getCitys(String stateCode,String countryCode);

	
	/**
	 * @param countryCode
	 * @return
	 */
	Country getCountryNameByCode(String countryCode);

	
	/**
	 * @param countryCode
	 * @param stateCode
	 * @return
	 */
	States getStateNameByCode(String countryCode, String stateCode);

	
	/**
	 * @param countryCode
	 * @param stateCode
	 * @param cityId
	 * @return
	 */
	City getCityNameById(String countryCode, String stateCode, String cityId);

   
    /**
     * @param countryCode
     * @param stateCode
     * @param cityName
     * @return
     */
    City getCityDetail(String countryCode, String stateCode, String cityName);


	public List<LocationResponse> fetchLocations(String authorizationToken, String correlationID,
			List<LocationRequest> requestList);

}
