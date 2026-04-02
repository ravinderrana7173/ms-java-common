package com.common.rest.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.cloud.api.common.util.ValidatorUtils;
import com.common.api.model.request.SystemRequest;
import com.common.rest.entity.CapabilityEntity;
import com.common.rest.entity.SystemCapabilityEntity;
import com.common.rest.entity.SystemEntity;

/**
 * The Class SystemRequestConversionUtil.
 */
@Component
public class SystemRequestConversionUtil {


    /**
     * To system entity.
     *
     * @param systemRequest the system request
     * @param capabilityEntities the capability entities
     * @param userUuid the user uuid
     * @return the system entity
     */
    public SystemEntity toSystemEntity(SystemRequest systemRequest,
            List<CapabilityEntity> capabilityEntities, String userUuid) {
        List<SystemCapabilityEntity> systemCapabilityList = new ArrayList<>();
        SystemEntity systemEntity = new SystemEntity();
        systemEntity.setSystemUuid(UUID.randomUUID().toString());
        systemEntity.setSystemName(systemRequest.getName());
        systemEntity.setIsSimulation(false);
        if (!ValidatorUtils.isNullOrEmpty(systemRequest.getDescription())) {
            systemEntity.setDescription(systemRequest.getDescription());
        }
        if (!ValidatorUtils.isNullOrEmpty(capabilityEntities)) {
            for (CapabilityEntity capabilityEntity : capabilityEntities) {
                SystemCapabilityEntity systemCapabilityEntity = new SystemCapabilityEntity();
                systemCapabilityEntity.setSystemEntity(systemEntity);
                systemCapabilityEntity.setCapabilityEntity(capabilityEntity);
                systemCapabilityEntity.setCreatedBy(userUuid);
                systemCapabilityEntity.setCreatedOn(Calendar.getInstance().getTime());
                systemCapabilityEntity.setModifiedBy(userUuid);
                systemCapabilityEntity.setModifiedOn(Calendar.getInstance().getTime());
                systemCapabilityList.add(systemCapabilityEntity);
            }
        }
        systemEntity.setSystemCapabilityEntity(systemCapabilityList);
        systemEntity.setCreatedBy(userUuid);
        systemEntity.setCreatedOn(Calendar.getInstance().getTime());
        systemEntity.setModifiedBy(userUuid);
        systemEntity.setModifiedOn(Calendar.getInstance().getTime());
        return systemEntity;
    }
   
}
