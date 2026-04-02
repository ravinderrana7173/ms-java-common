package com.common.rest.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.common.api.model.City;
import com.common.api.model.Country;
import com.common.api.model.States;
import com.common.rest.entity.CityEntity;
import com.common.rest.entity.CountryEntity;
import com.common.rest.entity.StateEntity;
import com.common.rest.repository.CityRepository;
import com.common.rest.repository.CountryRepository;
import com.common.rest.repository.StateRepository;
import com.common.rest.request.LocationRequest;
import com.common.rest.response.LocationResponse;
import com.common.rest.service.CommonService;
import com.common.rest.util.ConversionUtil;

/**
 * The Class CommonServiceImpl.
 */
@Service
public class CommonServiceImpl implements CommonService {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The states repository. */
	@Autowired
	private StateRepository stateRepository;

	/** The country repository. */
	@Autowired
	private CountryRepository countryRepository;

	/** The city repository. */
	@Autowired
	private CityRepository cityRepository;

	/**
	 * Gets the all country.
	 *
	 * @return the all country
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.common.service.CommonService#getAllCountry()
	 */
	@Override
	public List<Country> getAllCountry() {
		logger.info("[getAllCountry]- start");
		List<Country> countryList = new ArrayList<>();
		List<CountryEntity> countryEntityList = countryRepository.findAll();
		if (!CollectionUtils.isEmpty(countryEntityList)) {
			countryList = countryEntityList.stream().map(ConversionUtil::toSetCountry).collect(Collectors.toList());
			countryList.sort((Country s1, Country s2) -> s1.getName().compareTo(s2.getName()));
		}
		logger.info("[getAllCountry]- end");
		return countryList;
	}

	/**
	 * Gets the states.
	 *
	 * @param countryCode the country code
	 * @return the states
	 */
	@Override
	public List<States> getStates(String countryCode) {
		logger.info("[getStates]- start");

		List<States> statesResponseList = new ArrayList<>();

		if (!StringUtils.isEmpty(countryCode)) {
			logger.info("[getStates]- with country code");
			CountryEntity countryEntity = countryRepository.findByCountryCode2(countryCode);
			if (countryEntity != null) {
				List<StateEntity> statesEntityList = stateRepository
						.findByCountryEntityCountryId(countryEntity.getCountryId());
				statesResponseList = statesEntityList.stream().map(ConversionUtil::toSetAllStates)
						.collect(Collectors.toList());
				statesResponseList.sort((States s1, States s2) -> s1.getName().compareTo(s2.getName()));
			}
		} else {
			List<StateEntity> statesEntityList = stateRepository.findAll();
			if (!CollectionUtils.isEmpty(statesEntityList)) {
				logger.info("[getStates]- all states");
				statesResponseList = statesEntityList.stream().map(ConversionUtil::toSetAllStates)
						.collect(Collectors.toList());
				statesResponseList.sort((States s1, States s2) -> s1.getName().compareTo(s2.getName()));

			}
		}
		logger.info("[getStates]- end");
		return statesResponseList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.common.rest.service.CommonService#getCitys(String)
	 */
	public List<City> getCitys(String stateCode,String countryCode) {
		logger.info("[getCitys]- start");
		List<City> citysResponseList = new ArrayList<>();
		List<CityEntity> citysEntityList=null;
		if (stateCode != null || countryCode != null) {
			logger.info("[getCitys]- with state code");
            citysEntityList = cityRepository.getCity(stateCode, countryCode);
			if (citysEntityList != null) {
				citysResponseList = citysEntityList.stream().map(ConversionUtil::toSetAllCitys)
						.collect(Collectors.toList());
				citysResponseList.sort((City s1, City s2) -> s1.getName().compareTo(s2.getName()));
			}
		} else {
            List<CityEntity> citysEntity = cityRepository.findAll();
            if (!CollectionUtils.isEmpty(citysEntity)) {
                citysEntity.sort(Comparator.comparing(CityEntity::getCreatedOn).reversed());
                logger.info("[getCitys]- all citys");
                citysResponseList = citysEntity.stream().map(ConversionUtil::toSetAllCitys)
                        .collect(Collectors.toList());
                citysResponseList.sort((City s1, City s2) -> s1.getName().compareTo(s2.getName()));

            }
		}
		logger.info("[getCitys]- end");
		return citysResponseList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.common.rest.service.CommonService#getCountryNameByCode(java.lang.String)
	 */
	@Override
	public Country getCountryNameByCode(String countryCode) {
		logger.info("[getCountryNameByCode]- start");
		Country country = null;
		CountryEntity countryEntity = countryRepository.findByCountryCode2(countryCode);
		if (countryEntity != null) {
			country = new Country();
			country.setName(countryEntity.getCountryName());

		}
		logger.info("[getCountryNameByCode]- end");
		return country;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.common.rest.service.CommonService#getStateNameByCode(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public States getStateNameByCode(String countryCode, String stateCode) {
		logger.info("[getStateNameByCode]- start");
		States states = null;
		CountryEntity countryEntity = countryRepository.findByCountryCode2(countryCode);
		if (countryEntity != null) {
//			StateEntity stateEntity = stateRepository.findByStateCodeAndCountryEntityCountryId(stateCode,
//					countryEntity.getCountryId());
			
			List<StateEntity> stateEntityList = stateRepository.findByStateCodeAndNameAndCountryEntityCountryId(countryEntity.getCountryId(),
					stateCode, stateCode);
			 StateEntity stateEntity = null;
			if(stateEntityList != null && stateEntityList.size() > 0) {
                 stateEntity = stateEntityList.get(0);
			}
			if (stateEntity != null) {
				states = new States();
				states.setName(stateEntity.getStateName());
			}
		}
		logger.info("[getStateNameByCode]- end");
		return states;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.common.rest.service.CommonService#getCityNameById(java.lang.String)
	 */
	@Override
	public City getCityNameById(String countryCode, String stateCode, String cityId) {
		logger.info("[getCityNameById]- start");
		City city = null;
		CountryEntity countryEntity = countryRepository.findByCountryCode2(countryCode);
		if (countryEntity != null) {
//			StateEntity stateEntity = stateRepository.findByStateCodeAndCountryEntityCountryId(stateCode,
//					countryEntity.getCountryId());
			List<StateEntity> stateEntityList = stateRepository.findByStateCodeAndNameAndCountryEntityCountryId(countryEntity.getCountryId(),
					stateCode, stateCode);
			 StateEntity stateEntity = null;
			if(stateEntityList != null && stateEntityList.size() > 0) {
                 stateEntity = stateEntityList.get(0);
			}
			
			
			if (stateEntity != null) {
				CityEntity cityEntity = cityRepository.findByCityIdAndStateEntityStateId(Long.valueOf(cityId),
						stateEntity.getStateId());
				if (cityEntity != null) {
					city = new City();
					city.setName(cityEntity.getCityName());
				}
			}
		}
		logger.info("[getCityNameById]- start");
		return city;

	}
	
    @Override
    public City getCityDetail(String countryCode, String stateCode, String cityName) {
        logger.info("[getCityNameById]- start");
        City city = null;
        CountryEntity countryEntity = countryRepository.findByCountryCode2(countryCode);
        if (countryEntity != null) {
//            StateEntity stateEntity = stateRepository.findByStateCodeAndCountryEntityCountryId(
//                    stateCode, countryEntity.getCountryId());
        	
        	List<StateEntity> stateEntityList = stateRepository.findByStateCodeAndNameAndCountryEntityCountryId(countryEntity.getCountryId(),
					stateCode, stateCode);
			 StateEntity stateEntity = null;
			if(stateEntityList != null && stateEntityList.size() > 0) {
                 stateEntity = stateEntityList.get(0);
			}
            if (stateEntity != null) {
                CityEntity cityEntity = cityRepository.findByCityNameAndStateEntityStateId(cityName,
                        stateEntity.getStateId());
                if (cityEntity != null) {
                    city = new City();
                    city.setName(cityEntity.getCityName());
                    city.setCityID(cityEntity.getCityId());
                }
            }
        }
        logger.info("[getCityNameById]- start");
        return city;

    }
    
    @Override
	public List<LocationResponse> fetchLocations(String authorizationToken, String correlationID,
			List<LocationRequest> requestList) {
		logger.info("[fetchLocation]- start");
		List<LocationResponse> responseList = new ArrayList<>();

		if (CollectionUtils.isEmpty(requestList)) {
			return responseList;
		}

		for (LocationRequest r : requestList) {
			responseList.addAll(cityRepository.fetchLocation(r.getCountryCode().toLowerCase(),
					r.getStateCode().toLowerCase(), r.getCityCode().toLowerCase()));
		}

		logger.info("[fetchLocation]- end");
		return responseList;
	}
}
