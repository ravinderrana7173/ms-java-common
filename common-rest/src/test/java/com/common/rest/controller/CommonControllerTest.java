/*package com.common.rest.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.cloud.api.common.util.StringUtils;
import com.common.api.constant.CommonConstant;
import com.common.api.model.City;
import com.common.api.model.Country;
import com.common.api.model.States;
import com.common.rest.constant.AuthenticationMockData;
import com.common.rest.constant.CommonMockData;
import com.common.rest.service.CommonService;

*//**
 * The Class CommonControllerTest.
 *//*
@SpringBootTest
public class CommonControllerTest {

	*//** The common controller. *//*
	@InjectMocks
	private CommonRestController commonController;

	*//** The mock mvc. *//*
	private MockMvc mockMvc;

	*//** The country models. *//*
	List<Country> countryModels;

	*//** The states models. *//*
	List<States> statesModels;

	*//** The city models. *//*
	List<City> cityModels;

	*//** The common service. *//*
	@Mock
	private CommonService commonService;

	*//**
	 * Sets the up.
	 *//*
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(commonController).build();
	}

	*//**
	 * Test country.
	 *//*
	@Test
	public void testGetAllCountry() {
		countryModels = CommonMockData.getCountries();
		Mockito.when(commonService.getAllCountry()).thenReturn(countryModels);
		try {
			mockMvc.perform(get(CommonMockData.COUNTRY_URL)
					.header(CommonConstant.Header.AUTHORIZATION, AuthenticationMockData.authorization)
					.header(CommonConstant.Header.CORRELATION_ID, AuthenticationMockData.correlationid)
					.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andExpect(content().string(StringUtils.toJsonString(countryModels)));
			assertTrue(true);
		} catch (Exception e) {

			assertTrue(false);
		}

	}

	*//**
	 * Test all states.
	 *//*
	@Test
	public void testGetAllStates() {
		statesModels = CommonMockData.getStates();
		try {
			Mockito.when(commonService.getStates(Mockito.any(String.class))).thenReturn(statesModels);
			mockMvc.perform(get(CommonMockData.STATES_URL + CommonMockData.Code)
					.header(CommonConstant.Header.AUTHORIZATION, AuthenticationMockData.authorization)
					.header(CommonConstant.Header.CORRELATION_ID, AuthenticationMockData.correlationid)
					.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andExpect(content().string(StringUtils.toJsonString(statesModels)));
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	*//**
	 * Test get all city.
	 *//*
	@Test
	public void testGetAllCity() {
		cityModels = CommonMockData.getCity();
		try {
			Mockito.when(commonService.getCitys(Mockito.any(String.class),Mockito.any(String.class))).thenReturn(cityModels);
			mockMvc.perform(get(CommonMockData.CITY_URL + CommonMockData.Code+"&country=AUS")
					.header(CommonConstant.Header.AUTHORIZATION, AuthenticationMockData.authorization)
					.header(CommonConstant.Header.CORRELATION_ID, AuthenticationMockData.correlationid)
					.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andExpect(content().string(StringUtils.toJsonString(cityModels)));
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	*//**
	 * Test get country name by code.
	 *//*
	@Test
	public void testGetCountryNameByCode() {
		Country country = CommonMockData.getCountry();
		try {
			Mockito.when(commonService.getCountryNameByCode(Mockito.any(String.class))).thenReturn(country);
			mockMvc.perform(get(CommonMockData.COUNTRY_NAME_URL + CommonMockData.Code)
					.header(CommonConstant.Header.AUTHORIZATION, AuthenticationMockData.authorization)
					.header(CommonConstant.Header.CORRELATION_ID, AuthenticationMockData.correlationid)
					.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	*//**
	 * Test get state name by code.
	 *//*
	@Test
	public void testGetStateNameByCode() {
		States states = CommonMockData.getState();
		try {
			Mockito.when(commonService.getStateNameByCode(Mockito.any(String.class), Mockito.any(String.class)))
					.thenReturn(states);
			mockMvc.perform(get(CommonMockData.STATE_NAME_URL + CommonMockData.Code + CommonMockData.Code)
					.header(CommonConstant.Header.AUTHORIZATION, AuthenticationMockData.authorization)
					.header(CommonConstant.Header.CORRELATION_ID, AuthenticationMockData.correlationid)
					.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	*//**
	 * Test get city name by id.
	 *//*
	@Test
	public void testGetCityNameById() {
		City city = CommonMockData.getCityRes();
		try {
			Mockito.when(commonService.getCityNameById(Mockito.any(String.class), Mockito.any(String.class),
					Mockito.any(String.class))).thenReturn(city);
			mockMvc.perform(
					get(CommonMockData.CITY_NAME_URL + CommonMockData.Code + CommonMockData.Code + CommonMockData.Code)
							.header(CommonConstant.Header.AUTHORIZATION, AuthenticationMockData.authorization)
							.header(CommonConstant.Header.CORRELATION_ID, AuthenticationMockData.correlationid)
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}*/