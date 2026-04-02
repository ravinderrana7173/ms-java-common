package com.common.rest.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.common.api.model.response.CapabilityResponse;
import com.common.rest.entity.CapabilityEntity;

/**
 * The Class CapabilityEntityConversionUtil.
 */
@Component
public class CapabilityEntityConversionUtil {

     /**
     * To capability response.
     *
     * @param capabilityEntity the capability entity
     * @return the capability response
     */
    public CapabilityResponse toCapabilityResponse(CapabilityEntity capabilityEntity) {
        CapabilityResponse response = new CapabilityResponse();
        response.setDescription(capabilityEntity.getDescription());
        response.setName(capabilityEntity.getCapabilityName());
        response.setCode(capabilityEntity.getCapabilityCode());
        return response;
    }

    /**
     * To capability response list.
     *
     * @param capabilityEntities the capability entities
     * @return the list
     */
    public List<CapabilityResponse> toCapabilityResponseList(
            List<CapabilityEntity> capabilityEntities) {
        List<CapabilityResponse> capabilities = new ArrayList<CapabilityResponse>();
        for (CapabilityEntity capabilityEntity : capabilityEntities) {
            CapabilityResponse response = new CapabilityResponse();
            response = toCapabilityResponse(capabilityEntity);
            capabilities.add(response);
        }
        return capabilities;
    }

}
