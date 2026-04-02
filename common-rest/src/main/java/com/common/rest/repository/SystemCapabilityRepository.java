package com.common.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.common.rest.entity.SystemCapabilityEntity;

/**
 * The Interface CityRepository.
 */
@Repository
public interface SystemCapabilityRepository extends JpaRepository<SystemCapabilityEntity, Long> {

    /**
     * Delete by system id.
     *
     * @param systemId the system id
     */
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("delete from SystemCapabilityEntity cap where cap.systemEntity.systemId=:systemId")
    public void deleteBySystemId(@Param("systemId") Long systemId);
}
