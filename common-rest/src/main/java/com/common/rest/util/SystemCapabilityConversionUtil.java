package com.common.rest.util;

import java.util.Calendar;

import com.common.rest.entity.CapabilityEntity;
import com.common.rest.entity.SystemCapabilityEntity;
import com.common.rest.entity.SystemEntity;

/**
 * The Class SystemCapabilityConversionUtil.
 */
public class SystemCapabilityConversionUtil {

    /**
     * Instantiates a new system capability conversion util.
     */
    private SystemCapabilityConversionUtil() {
        super();
    }

    /**
     * To system capability entity.
     *
     * @param systemEntity the system entity
     * @param capabilityEntity the capability entity
     * @param userUuid the user uuid
     * @return the system capability entity
     */
    public static SystemCapabilityEntity toSystemCapabilityEntity(SystemEntity systemEntity,
            CapabilityEntity capabilityEntity, String userUuid) {
        SystemCapabilityEntity systemCapabilityEntity = new SystemCapabilityEntity();
        systemCapabilityEntity.setSystemEntity(systemEntity);
        systemCapabilityEntity.setCapabilityEntity(capabilityEntity);
        systemCapabilityEntity.setCreatedBy(userUuid);
        systemCapabilityEntity.setCreatedOn(Calendar.getInstance().getTime());
        systemCapabilityEntity.setModifiedBy(userUuid);
        systemCapabilityEntity.setModifiedOn(Calendar.getInstance().getTime());
        return systemCapabilityEntity;
    }
}
