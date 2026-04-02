package com.common.rest.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cloud.api.common.util.ValidatorUtils;
import com.cloud.p7.auth.context.ServerContext;
import com.common.api.model.request.SystemRequest;
import com.common.api.model.response.CapabilityResponse;
import com.common.api.model.response.SystemResponse;
import com.common.rest.entity.CapabilityEntity;
import com.common.rest.entity.SystemCapabilityEntity;
import com.common.rest.entity.SystemEntity;
import com.common.rest.repository.CapabilityRepository;
import com.common.rest.repository.SystemCapabilityRepository;
import com.common.rest.repository.SystemRepository;
import com.common.rest.service.SystemService;
import com.common.rest.util.CapabilityEntityConversionUtil;
import com.common.rest.util.MessageUtil;
import com.common.rest.util.SystemCapabilityConversionUtil;
import com.common.rest.util.SystemEntityConversionUtil;
import com.common.rest.util.SystemRequestConversionUtil;

import lombok.extern.slf4j.Slf4j;



/** The Constant log. */
@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SystemServiceImpl implements SystemService {

    /** The system repository. */
    @Autowired
    private SystemRepository systemRepository;

    /** The capability repository. */
    @Autowired
    private CapabilityRepository capabilityRepository;

    /** The system capability repository. */
    @Autowired
    private SystemCapabilityRepository systemCapabilityRepository;

    /** The capability entity conversion util. */
    @Autowired
    private CapabilityEntityConversionUtil capabilityEntityConversionUtil;

    /** The system entity conversion util. */
    @Autowired
    private SystemEntityConversionUtil systemEntityConversionUtil;

    @Autowired
    private SystemRequestConversionUtil systemRequestConversionUtil;

    /** The server context. */
    @Autowired
    private ServerContext serverContext;

    /** The message util. */
    @Autowired
    protected MessageUtil messageUtil;

    /**
     * Gets the all systems.
     *
     * @param systemName the system name
     * @return the all systems
     */
    @Override
    @Transactional(readOnly = true)
	public List<SystemResponse> getAll(String systemName, String capabilityCode) {
		List<SystemResponse> systemResponse = new ArrayList<>();
		List<SystemEntity> systemEntities = null;
		log.info("[getAllSystems] Fetching all system list from DB by system name{}", systemName);
		if (systemName != null && capabilityCode != null) {
			systemEntities = systemRepository.findBySystemNameAndSystemCapabilityEntity_capabilityEntity_capabilityCode(
					systemName, capabilityCode);
		} else if (systemName == null && capabilityCode != null) {
			systemEntities = systemRepository
					.findBySystemCapabilityEntity_capabilityEntity_capabilityCode(capabilityCode);
		} else {
			systemEntities = systemRepository.findAll(systemName);
		}
		log.info("[getAllSystems] empty check for system ");
		if (!CollectionUtils.isEmpty(systemEntities)) {
			log.info("[getAllSystems] Converting SystemEntity into SystemResponse");
			systemResponse = systemEntityConversionUtil.toSystemResponseList(systemEntities);
		}
		return systemResponse;
	}

    /**
     * Gets the all capability.
     *
     * @return the all capability
     */
    @Override
    @Transactional(readOnly = true)
    public List<CapabilityResponse> getAllCapability() {
        List<CapabilityResponse> capabilitiesResponse = new ArrayList<CapabilityResponse>();
        log.info("[getAllCapability] Fetching all capability list from DB");
        List<CapabilityEntity> capabilityEntities = capabilityRepository.findAll();
        log.info("[getAllCapability] verifying capability list");
        if (capabilityEntities != null && capabilityEntities.size() > 0) {
            log.info("[getAllCapability] Converting CapabilityEntity into CapabilityResponse");
            capabilitiesResponse =
                    capabilityEntityConversionUtil.toCapabilityResponseList(capabilityEntities);
        }
        return capabilitiesResponse;
    }

    /**
     * Creates the new system.
     *
     * @param systemRequest the system request
     * @return the system response
     */
    @Override
    public SystemResponse create(SystemRequest systemRequest) {
        List<CapabilityEntity> capabilityEntities = new ArrayList<CapabilityEntity>();
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getCapabilityCodes())) {
            log.info("[create] Fetching Capabilty Entity from DB based on capabilityCodes {}",
                    systemRequest.getCapabilityCodes());
            capabilityEntities =
                    capabilityRepository.findByCapabilityCodeIn(systemRequest.getCapabilityCodes());
        }

        log.info("[create] converting systemRequest to systemEntity to save in DB");
        SystemEntity systemEntity = systemRequestConversionUtil.toSystemEntity(systemRequest,
                capabilityEntities, serverContext.getRequestContext().getUserUuid());
        log.info("[create] saving systemEntity in DB");
        SystemEntity systemEntityResponse = systemRepository.save(systemEntity);
        log.info("[create] Preparing response by converting SystemEntity {} into SystemResponse.",
                systemEntityResponse);
        return systemEntityConversionUtil.toSystemResponse(systemEntityResponse);
    }

    /**
     * Update system.
     *
     * @param systemRequest the system request
     * @param systemUuid the system uuid
     * @return the system response
     */
    @Override
    public SystemResponse update(SystemRequest systemRequest, String systemUuid) {
        log.info("[update] - fetching system detail by systemUuid{}", systemUuid);
        SystemEntity systemEntity = systemRepository.findBySystemUuid(systemUuid);
        log.info("[update] - empty check for name");
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getName())) {
            systemEntity.setSystemName(systemRequest.getName());
        }
        log.info("[update] - empty check for description");
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getDescription())) {
            systemEntity.setDescription(systemRequest.getDescription());
        }
        else if(ValidatorUtils.isNullOrEmpty(systemRequest.getDescription()))
        {
            systemEntity.setDescription("");
        }
        log.info("[update] - empty check for capability codes");
        if(systemRequest.getCapabilityCodes()!=null)
        {
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getCapabilityCodes().size() > 0)
                && !ValidatorUtils.isNullOrEmpty(systemRequest.getCapabilityCodes().size() > 0)) {
            log.info("[update] - deleting system capabilities from db");
            systemCapabilityRepository.deleteBySystemId(systemEntity.getSystemId());
            log.info("[update] Fetching Capabilty Entity from DB based on capabilityCodes {}",
                    systemRequest.getCapabilityCodes());
            List<CapabilityEntity> capabilityEntities =
                    capabilityRepository.findByCapabilityCodeIn(systemRequest.getCapabilityCodes());
            List<SystemCapabilityEntity> systemCapabilityList = new ArrayList<>();
            log.info("[update] iterating capability entities to create system capability entity ");
            for (CapabilityEntity capabilityEntity : capabilityEntities) {
                SystemCapabilityEntity systemCapabilityEntity =
                        SystemCapabilityConversionUtil.toSystemCapabilityEntity(systemEntity,
                                capabilityEntity, serverContext.getRequestContext().getUserUuid());
                systemCapabilityList.add(systemCapabilityEntity);
            }
            systemEntity.setSystemCapabilityEntity(systemCapabilityList);

        }
        }
        systemEntity.setModifiedBy(serverContext.getRequestContext().getUserUuid());
        systemEntity.setModifiedOn(Calendar.getInstance().getTime());
        log.info("[update] updating systemEntity in DB");
        SystemEntity systemEntityResponse = systemRepository.save(systemEntity);
        log.info("[update] Preparing response by converting SystemEntity {} into SystemResponse.",
                systemEntityResponse);
        return systemEntityConversionUtil.toSystemResponse(systemEntityResponse);

    }

    /**
     * Gets the system by system uuid.
     *
     * @param systemUuid the system uuid
     * @return the system by system uuid
     */
    @Override
    @Transactional(readOnly = true)
    public SystemResponse getByUuid(String systemUuid) {
        log.info("[getByUuid] Fetching System Entity for Uuid {} from DB", systemUuid);
        SystemEntity systemEntity = systemRepository.findBySystemUuid(systemUuid);
        log.info(
                "[getByUuid] Preparing response by converting SystemEntity {} into SystemResponse.",
                systemEntity);
        return systemEntityConversionUtil.toSystemResponse(systemEntity);
    }


    /**
     * Delete system by system uuid.
     *
     * @param systemUuid the system uuid
     */
    @Override
    public void delete(String systemUuid) {
        log.info("[delete] Fetching System Entity for Uuid {} from DB", systemUuid);
        SystemEntity systemEntity = systemRepository.findBySystemUuid(systemUuid);
        log.info("[delete] deleting system entity from DB");
        systemRepository.delete(systemEntity);

    }

}
