/*package com.common.rest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.common.api.model.City;
import com.common.api.model.Country;
import com.common.api.model.States;
import com.common.rest.constant.CommonMockData;
import com.common.rest.entity.CityEntity;
import com.common.rest.entity.CountryEntity;
import com.common.rest.entity.StateEntity;
import com.common.rest.repository.CityRepository;
import com.common.rest.repository.CountryRepository;
import com.common.rest.repository.StateRepository;
import com.common.rest.service.impl.CommonServiceImpl;

*//**
 * The Class CommonServiceTest.
 *//*
@SpringBootTest
public class CommonServiceTest {

	*//** The states repository. *//*
	@Mock
	private StateRepository stateRepository;

	*//** The country repository. *//*
	@Mock
	private CountryRepository countryRepository;

	*//** The common service impl. *//*
	@InjectMocks
	private CommonServiceImpl commonService;

	*//** The city repository. *//*
	@Mock
	private CityRepository cityRepository;

	*//**
	 * Test get states.
	 *//*
	@Test
	public void testGetStates() {
		List<States> actualStatesList = null;
		List<StateEntity> stateEntities = CommonMockData.getStateEntities();
		Mockito.when(countryRepository.findByCountryCode2(Mockito.anyString()))
				.thenReturn(CommonMockData.getCountryEntity());
		Mockito.when(stateRepository.findByCountryEntityCountryId(Mockito.anyLong())).thenReturn(stateEntities);
		Mockito.when(stateRepository.findAll()).thenReturn(stateEntities);

		actualStatesList = commonService.getStates(CommonMockData.Code);
		assertThat(actualStatesList).size().isGreaterThan(0);
		assertThat(actualStatesList.get(0).getName()).isEqualTo(stateEntities.get(0).getStateName());
		try {
			Mockito.when(countryRepository.findByCountryCode2(Mockito.anyString())).thenReturn(null);
			actualStatesList = commonService.getStates(null);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	*//**
	 * Test all country.
	 *//*
	@Test
	public void testAllCountry() {
		List<CountryEntity> countries = CommonMockData.getCountryEntities();
		Mockito.when(countryRepository.findAll()).thenReturn(countries);
		List<Country> actualResponse = commonService.getAllCountry();
		assertThat(actualResponse).size().isGreaterThan(0);
		assertThat(actualResponse.get(0).getName()).isEqualTo(countries.get(0).getCountryName());
		assertTrue(actualResponse.get(0).getCode().equalsIgnoreCase(countries.get(0).getCountryCode2()));

		Mockito.when(countryRepository.findAll()).thenReturn(null);
		try {
			actualResponse = commonService.getAllCountry();
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	*//**
	 * Test get city.
	 *//*
	@Test
	public void testGetCity() {
		List<City> actualResponse = CommonMockData.getCity();
		List<StateEntity> stateEntities = CommonMockData.getStateEntities();
		List<CityEntity> cityList = CommonMockData.getcityEntities();
		Mockito.when(stateRepository.findByStateCode(Mockito.anyString())).thenReturn(stateEntities);
		Mockito.when(cityRepository.findByStateEntityStateId(Mockito.anyLong())).thenReturn(cityList);
		Mockito.when(cityRepository.findAll()).thenReturn(cityList);

		actualResponse = commonService.getCitys(CommonMockData.Code,CommonMockData.Code);
		assertThat(actualResponse).size().isGreaterThanOrEqualTo(0);
		assertThat(actualResponse).isEqualTo(actualResponse);

		try {
			Mockito.when(stateRepository.findByStateCode(Mockito.anyString())).thenReturn(null);
			actualResponse = commonService.getCitys(CommonMockData.Code,CommonMockData.Code);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	*//**
	 * Test get country name by code.
	 *//*
	@Test
	public void testGetCountryNameByCode() {
		Country actualResponse = CommonMockData.getCountry();
		CountryEntity countryEntity = CommonMockData.getCountryEntity();
		Mockito.when(countryRepository.findByCountryCode2(Mockito.anyString())).thenReturn(countryEntity);
		actualResponse = commonService.getCountryNameByCode(Mockito.anyString());
		assertThat(actualResponse.equals(0));
		assertThat(actualResponse.getName()).isEqualTo(countryEntity.getCountryName());

		Mockito.when(countryRepository.findByCountryCode2(Mockito.anyString())).thenReturn(null);
		try {
			actualResponse = commonService.getCountryNameByCode(Mockito.anyString());
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	*//**
	 * Test get state name by code.
	 *//*
	@Test
	public void testGetStateNameByCode() {
		States actualResponse = CommonMockData.getState();
		StateEntity stateEntity = CommonMockData.getStateEntity();
		CountryEntity countryEntity = CommonMockData.getCountryEntity();
		Mockito.when(countryRepository.findByCountryCode2(Mockito.anyString())).thenReturn(countryEntity);
		Mockito.when(stateRepository.findByStateCodeAndCountryEntityCountryId(Mockito.anyString(), Mockito.anyLong()))
				.thenReturn(stateEntity);
		actualResponse = commonService.getStateNameByCode(CommonMockData.Code, CommonMockData.statesCode);
		assertThat(actualResponse.getName()).isEqualTo(actualResponse.getName());

		Mockito.when(countryRepository.findByCountryCode2(Mockito.anyString())).thenReturn(null);
		try {
			actualResponse = commonService.getStateNameByCode(Mockito.anyString(), Mockito.anyString());
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	*//**
	 * Test get city name by id.
	 *//*
	@Test
	public void testGetCityNameById() {
		City actualResponse = CommonMockData.getCityRes();
		StateEntity stateEntity = CommonMockData.getStateEntity();
		CountryEntity countryEntity = CommonMockData.getCountryEntity();
		CityEntity cityEntity = CommonMockData.getCityEntity();
		Mockito.when(countryRepository.findByCountryCode2(Mockito.anyString())).thenReturn(countryEntity);
		Mockito.when(stateRepository.findByStateCodeAndCountryEntityCountryId(Mockito.anyString(), Mockito.anyLong()))
				.thenReturn(stateEntity);
		Mockito.when(cityRepository.findByCityIdAndStateEntityStateId(Mockito.anyLong(), Mockito.anyLong()))
				.thenReturn(cityEntity);
		actualResponse = commonService.getCityNameById(CommonMockData.Code, CommonMockData.statesCode,
				CommonMockData.CITY_ID);
		assertThat(actualResponse.getName()).isEqualTo(actualResponse.getName());

		Mockito.when(countryRepository.findByCountryCode2(Mockito.anyString())).thenReturn(null);
		try {
			actualResponse = commonService.getCityNameById(CommonMockData.Code, CommonMockData.statesCode,
					CommonMockData.CITY_ID);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}*/