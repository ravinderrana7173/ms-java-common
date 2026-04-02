package com.common.rest.util;

import com.common.api.model.City;
import com.common.api.model.Country;
import com.common.api.model.States;
import com.common.rest.entity.CityEntity;
import com.common.rest.entity.CountryEntity;
import com.common.rest.entity.StateEntity;

/**
 * The Class ConversionUtil.
 */
public class ConversionUtil {

	/**
	 * Instantiates a new conversion util.
	 */
	private ConversionUtil() {
		throw new IllegalStateException("Utility class");
	}


	/**
	 * @param countryEntity
	 * @return
	 */
	public static Country toSetCountry(CountryEntity countryEntity) {
		Country country = new Country();
		country.setName(countryEntity.getCountryName());
		country.setCode(countryEntity.getCountryCode2());
		return country;
	}

	
	/**
	 * @param statesEntity
	 * @return
	 */
	public static States toSetAllStates(StateEntity statesEntity) {
		States states = new States();
		states.setCountry(statesEntity.getCountryEntity().getCountryCode2());
		states.setCode(statesEntity.getStateCode());
		states.setName(statesEntity.getStateName());
		return states;
	}

	
	/**
	 * @param cityEntity
	 * @return
	 */
	public static City toSetAllCitys(CityEntity cityEntity) {
		City citys = new City();
		citys.setCityID(cityEntity.getCityId());
		citys.setName(cityEntity.getCityName());
		citys.setStateCode(cityEntity.getStateEntity().getStateCode());
		citys.setCountryCode(cityEntity.getStateEntity().getCountryEntity().getCountryCode2());
		return citys;
	}
    
}
