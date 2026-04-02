package com.common.rest.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.common.api.model.response.CapabilityDetailsResponse;
import com.common.api.model.response.SystemResponse;
import com.common.rest.entity.SystemCapabilityEntity;
import com.common.rest.entity.SystemEntity;

/**
 * The Class SystemEntityConversionUtil.
 */
@Component
public class SystemEntityConversionUtil {

	/**
	 * To system response.
	 *
	 * @param systemEntity the system entity
	 * @return the system response
	 */
	public SystemResponse toSystemResponse(SystemEntity systemEntity) {
		List<String> capabilityNameList = new ArrayList<String>();
		List<CapabilityDetailsResponse> detailsResponses = new ArrayList<CapabilityDetailsResponse>();
		
		List<SystemCapabilityEntity> systemCapabilityEntityList = systemEntity.getSystemCapabilityEntity();
		for (SystemCapabilityEntity systemCapabilityEntity : systemCapabilityEntityList) {
			capabilityNameList.add(systemCapabilityEntity.getCapabilityEntity().getCapabilityName());
		}
		SystemResponse response = new SystemResponse();
		response.setDescription(systemEntity.getDescription());
		response.setName(systemEntity.getSystemName());
		response.setSystemCode(systemEntity.getSystemCode());
		response.setIsSimulation(systemEntity.getIsSimulation());
		response.setUuid(systemEntity.getSystemUuid());
		/*
		 * if (!StringUtils.isEmpty(systemEntity.getLogo())) {
		 * response.setLogo(systemEntity.getLogo()); }
		 */
		if (!CollectionUtils.isEmpty(systemEntity.getSystemCapabilityDetailsEntities())) {
				
			systemEntity.getSystemCapabilityDetailsEntities().forEach(capabilityDetails -> {
				CapabilityDetailsResponse detailsResponse = new CapabilityDetailsResponse();
				detailsResponse.setKey(capabilityDetails.getKey());
				detailsResponse.setValue(capabilityDetails.getValue());
				detailsResponses.add(detailsResponse);
	   		});
			
			response.setCapabilityDetailsResponseList(detailsResponses);
		}
		
		response.setCapabilities(capabilityNameList);
		return response;
	}

	/**
	 * To system response list.
	 *
	 * @param systemEntityList the system entity list
	 * @return the list
	 */
	public List<SystemResponse> toSystemResponseList(List<SystemEntity> systemEntityList) {
		List<SystemResponse> systemResponseList = new ArrayList<SystemResponse>();
		for (SystemEntity systemEntity : systemEntityList) {
			SystemResponse response = new SystemResponse();
			response = toSystemResponse(systemEntity);
			systemResponseList.add(response);
		}
		return systemResponseList;
	}

}
