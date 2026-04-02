package com.common.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.common.rest.entity.CityEntity;
import com.common.rest.response.LocationResponse;

import java.util.List;

/**
 * The Interface CityRepository.
 */
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

   
    /**
     * @param stateId
     * @return
     */
    List<CityEntity> findByStateEntityStateId(Long stateId);
    

   
    /**
     * @param cityId
     * @param stateId
     * @return
     */
    CityEntity findByCityIdAndStateEntityStateId(Long cityId, Long stateId);
    
    
    
   
    /**
     * @param stateCode
     * @param countryCode
     * @return
     */
    @Query("SELECT md FROM CityEntity md "
            + "WHERE COALESCE(md.stateEntity.stateCode,'')= COALESCE(:stateCode, md.stateEntity.stateCode) "
            + "AND COALESCE(md.stateEntity.countryEntity.countryCode2,'')= COALESCE(:countryCode, md.stateEntity.countryEntity.countryCode2) "
            + "order by md.createdOn desc")
    List<CityEntity> getCity(String stateCode, String countryCode);
    
   
    /**
     * @param cityName
     * @param stateId
     * @return
     */
    CityEntity findByCityNameAndStateEntityStateId(String cityName, Long stateId);



    @Query("""
			SELECT new com.common.rest.response.LocationResponse(
			   co.countryCode2,
			   co.countryName,
			   st.stateCode,
			   st.stateName,
			   ci.cityName,
			   ci.cityName
			)
			FROM CityEntity ci
			JOIN ci.stateEntity st
			JOIN st.countryEntity co
			WHERE
			   (LOWER(co.countryCode2) = :countryCode
			    AND LOWER(st.stateCode) = :stateCode
			    AND LOWER(ci.cityName) = :cityCode)
			""")
	List<LocationResponse> fetchLocation(@Param("countryCode") String countryCode, @Param("stateCode") String stateCode,
			@Param("cityCode") String cityCode);
    
}
