package com.common.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.common.rest.entity.SystemEntity;

import java.util.List;

/**
 * The Interface CityRepository.
 */
@Repository
public interface SystemRepository extends JpaRepository<SystemEntity, Long> {

	/**
	 * Find by system uuid.
	 *
	 * @param systemUuid the system uuid
	 * @return the system entity
	 */
	SystemEntity findBySystemUuid(String systemUuid);

	/**
	 * Find by system name.
	 *
	 * @param systemName the system name
	 * @return the system entity
	 */
	SystemEntity findBySystemName(String systemName);

	/**
	 * Find all.
	 *
	 * @param systemName the system name
	 * @return the list
	 */
	@Query("SELECT sys FROM SystemEntity sys "
			+ "WHERE COALESCE(sys.systemName,'')= COALESCE(:systemName, sys.systemName) "
			+ "order by sys.createdOn desc")
	List<SystemEntity> findAll(String systemName);

	/**
	 * Find by system name and system capability entity capability entity capability
	 * code.
	 *
	 * @param systemName     the system name
	 * @param capabilityCode the capability code
	 * @return the list
	 */
	List<SystemEntity> findBySystemNameAndSystemCapabilityEntity_capabilityEntity_capabilityCode(String systemName,
			String capabilityCode);

	/**
	 * Find by system capability entity capability entity capability code.
	 *
	 * @param capabilityCode the capability code
	 * @return the list
	 */
	List<SystemEntity> findBySystemCapabilityEntity_capabilityEntity_capabilityCode(String capabilityCode);
}
