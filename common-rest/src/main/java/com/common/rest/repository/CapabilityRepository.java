package com.common.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.common.rest.entity.CapabilityEntity;

/**
 * The Interface CityRepository.
 */
@Repository
public interface CapabilityRepository extends JpaRepository<CapabilityEntity, Long> {

    /**
     * Find by capability name.
     *
     * @param capabilityName the capability name
     * @return the capability entity
     */
    CapabilityEntity findByCapabilityName(String capabilityName);
    
    /**
     * Find by capability code.
     *
     * @param capabilityCode the capability code
     * @return the capability entity
     */
    CapabilityEntity findByCapabilityCode(String capabilityCode);
    
    /**
     * Find by capability code in.
     *
     * @param capabilityCodeList the capability code list
     * @return the list
     */
    List<CapabilityEntity> findByCapabilityCodeIn(List<String> capabilityCodeList);
    
    
}
