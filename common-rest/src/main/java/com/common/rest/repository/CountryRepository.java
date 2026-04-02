package com.common.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.common.rest.entity.CountryEntity;


/**
 * The Interface CountryRepository.
 */
@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

	/**
	 * Find by country code 2.
	 *
	 * @param statusCode the status code
	 * @return the country entity
	 */
	CountryEntity findByCountryCode2(String statusCode);

}
