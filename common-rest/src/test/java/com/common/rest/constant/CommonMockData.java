/*package com.common.rest.constant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.common.api.model.City;
import com.common.api.model.Country;
import com.common.api.model.States;
import com.common.rest.entity.CityEntity;
import com.common.rest.entity.CountryEntity;
import com.common.rest.entity.StateEntity;

*//**
 * The Class CommonMockData.
 *//*
public class CommonMockData {

	*//** The Constant correlationid. *//*
	public static final String correlationid = UUID.randomUUID().toString();

	*//** The Constant Country. *//*
	public static final String Country = "Country Name";

	*//** The Constant Code. *//*
	public static final String Code = "CAN";

	*//** The Constant statesCode. *//*
	public static final String statesCode = "BU";

	*//** The Constant statesName. *//*
	public static final String statesName = "Buskerud";

	*//** The Constant NAME. *//*
	public static final String NAME = "name";

	*//** The Constant COUNTRY_URL. *//*
	public static final String COUNTRY_URL = "/country/";

	*//** The Constant STATES_URL. *//*
	public static final String STATES_URL = "/states?country=";

	*//** The Constant CITY_URL. *//*
	public static final String CITY_URL = "/city?state=";

	*//** The Constant COUNTRY_NAME_URL. *//*
	public static final String COUNTRY_NAME_URL = "/country_name?countryCode=";

	*//** The Constant STATE_NAME_URL. *//*
	public static final String STATE_NAME_URL = "/state_name?countryCode=''&state=''";

	*//** The Constant CITY_NAME_URL. *//*
	public static final String CITY_NAME_URL = "/city_name?countryCode=''&state=''&cityId=''";

	*//** The Constant CITY_ID. *//*
	public static final String CITY_ID = "11";

	*//**
	 * Gets the countries.
	 *
	 * @return the countries
	 *//*
	public static List<Country> getCountries() {
		List<Country> countryList = new ArrayList<>();
		Country country = new Country();
		country.setName(Country);
		country.setCode(Code);
		countryList.add(country);
		return countryList;
	}

	*//**
	 * Gets the states.
	 *
	 * @return the states
	 *//*
	public static List<States> getStates() {
		List<States> entities = new ArrayList<>();
		States states = new States();
		states.setCode(statesCode);
		states.setCountry(Code);
		states.setName(statesName);
		entities.add(states);
		return entities;
	}

	*//**
	 * Gets the country entities.
	 *
	 * @return the country entities
	 *//*
	public static List<CountryEntity> getCountryEntities() {
		List<CountryEntity> countryEntities = new ArrayList<CountryEntity>();
		countryEntities.add(getCountryEntity());
		return countryEntities;
	}

	*//**
	 * Gets the state entities.
	 *
	 * @return the state entities
	 *//*
	public static List<StateEntity> getStateEntities() {
		List<StateEntity> stateEntities = new ArrayList<StateEntity>();
		stateEntities.add(getStateEntity());
		return stateEntities;
	}

	*//**
	 * Gets the country entity.
	 *
	 * @return the country entity
	 *//*
	public static CountryEntity getCountryEntity() {
		CountryEntity entity = new CountryEntity();
		entity.setCountryName("Canada");
		entity.setCountryCode1("CA");
		entity.setCountryCode2("CAN");
		entity.setCountryNumber("124");
		entity.setCountryIdd(new Long("001"));
		entity.setZipRequired(true);
		entity.setActive(true);
		entity.setCountryId(new Long(1));
		return entity;
	}

	*//**
	 * Gets the state entity.
	 *
	 * @return the state entity
	 *//*
	public static StateEntity getStateEntity() {
		StateEntity entity = new StateEntity();
		entity.setStateId(11l);
		entity.setStateCode(statesCode);
		entity.setActive(true);
		entity.setCountryEntity(getCountryEntity());
		entity.setStateName("Ontario:");
		return entity;
	}

	*//**
	 * Gets the city.
	 *
	 * @return the city
	 *//*
	public static List<City> getCity() {
		List<City> cityList = new ArrayList<>();
		City city = new City();
		city.setCityID(1l);
		city.setName(NAME);
		city.setCountryCode(Code);
		city.setStateCode(statesCode);
		cityList.add(city);
		return cityList;
	}

	*//**
	 * Gets the country.
	 *
	 * @return the country
	 *//*
	public static Country getCountry() {
		Country country = new Country();
		country.setName(Country);
		country.setCode(Code);
		return country;
	}

	*//**
	 * Gets the state.
	 *
	 * @return the state
	 *//*
	public static States getState() {
		States states = new States();
		states.setCode(statesCode);
		states.setCountry(Code);
		states.setName(statesName);
		return states;
	}

	*//**
	 * Gets the city res.
	 *
	 * @return the city res
	 *//*
	public static City getCityRes() {
		City city = new City();
		city.setCityID(1l);
		city.setName(NAME);
		city.setCountryCode(Code);
		city.setStateCode(statesCode);
		return city;
	}

	*//**
	 * Gets the city entities.
	 *
	 * @return the city entities
	 *//*
	public static List<CityEntity> getcityEntities() {
		List<CityEntity> cityList = new ArrayList<>();
		CityEntity cityEntity = new CityEntity();
		cityEntity.setCityId(1l);
		cityEntity.setCityName(NAME);
		cityEntity.setStateEntity(getStateEntity());
		cityList.add(cityEntity);
		return cityList;
	}

	*//**
	 * Gets the city entity.
	 *
	 * @return the city entity
	 *//*
	public static CityEntity getCityEntity() {
		CityEntity cityEntity = new CityEntity();
		cityEntity.setStateEntity(getStateEntity());
		cityEntity.setCityId(1l);
		cityEntity.setCityName(NAME);
		return cityEntity;
	}
}*/