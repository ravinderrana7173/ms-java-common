package com.common.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.common.rest.entity.StateEntity;

/**
 * The Interface StatesRepository.
 */
@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {

	/**
	 * Find by country entity country id.
	 *
	 * @param countryId the country id
	 * @return the list
	 */
	List<StateEntity> findByCountryEntityCountryId(Long countryId);

	/**
	 * Find by state code.
	 *
	 * @param stateCode the state code
	 * @return the list
	 */
	List<StateEntity> findByStateCode(String stateCode);

	/**
	 * Find by state code and country entity country id.
	 *
	 * @param stateCode the state code
	 * @param countryId the country id
	 * @return the state entity
	 */
//	StateEntity findByStateCodeAndCountryEntityCountryId(String stateCode, Long countryId);
	
	
	@Query("SELECT s FROM StateEntity s WHERE s.countryEntity.countryId = :country AND " +
		       "(LOWER(s.stateCode) = LOWER(:code) OR LOWER(s.stateName) = LOWER(:name))")
		List<StateEntity> findByStateCodeAndNameAndCountryEntityCountryId(
		    @Param("country") Long country,
		    @Param("name") String name,
		    @Param("code") String code
		);

}
