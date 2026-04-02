package com.common.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Class CountryEntity.
 */

@Entity
@Table(name = "com_country")
public class CountryEntity extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The country id. */
	@Id
	@Column(name = "country_id", length = 20, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long countryId;

	/** The country name. */
	@Column(name = "country_name", length = 100, nullable = false)
	private String countryName;

	/** The country code 1. */
	@Column(name = "country_code1", length = 20, nullable = false)
	private String countryCode1;

	/** The country code 2. */
	@Column(name = "country_code2", length = 20, nullable = false)
	private String countryCode2;

	/** The country number. */
	@Column(name = "country_number", length = 100, nullable = true)
	private String countryNumber;

	/** The country idd. */
	@Column(name = "country_idd", length = 100, nullable = true)
	private Long countryIdd;

	/** The zip required. */
	@Column(name = "zip_required", length = 1, nullable = false)
	private boolean zipRequired;

	/** The is active. */
	@Column(name = "is_active", length = 1, nullable = false)
	private boolean isActive;

	/**
	 * Gets the country id.
	 *
	 * @return the country id
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * Sets the country id.
	 *
	 * @param countryId
	 *            the new country id
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	/**
	 * Gets the country name.
	 *
	 * @return the country name
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Sets the country name.
	 *
	 * @param countryName
	 *            the new country name
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * Gets the country code 1.
	 *
	 * @return the country code 1
	 */
	public String getCountryCode1() {
		return countryCode1;
	}

	/**
	 * Sets the country code 1.
	 *
	 * @param countryCode1
	 *            the new country code 1
	 */
	public void setCountryCode1(String countryCode1) {
		this.countryCode1 = countryCode1;
	}

	/**
	 * Gets the country code 2.
	 *
	 * @return the country code 2
	 */
	public String getCountryCode2() {
		return countryCode2;
	}

	/**
	 * Sets the country code 2.
	 *
	 * @param countryCode2
	 *            the new country code 2
	 */
	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}

	/**
	 * Gets the country number.
	 *
	 * @return the country number
	 */
	public String getCountryNumber() {
		return countryNumber;
	}

	/**
	 * Sets the country number.
	 *
	 * @param countryNumber
	 *            the new country number
	 */
	public void setCountryNumber(String countryNumber) {
		this.countryNumber = countryNumber;
	}

	/**
	 * Gets the country idd.
	 *
	 * @return the country idd
	 */
	public Long getCountryIdd() {
		return countryIdd;
	}

	/**
	 * Sets the country idd.
	 *
	 * @param countryIdd
	 *            the new country idd
	 */
	public void setCountryIdd(Long countryIdd) {
		this.countryIdd = countryIdd;
	}

	/**
	 * Checks if is zip required.
	 *
	 * @return true, if is zip required
	 */
	public boolean isZipRequired() {
		return zipRequired;
	}

	/**
	 * Sets the zip required.
	 *
	 * @param zipRequired
	 *            the new zip required
	 */
	public void setZipRequired(boolean zipRequired) {
		this.zipRequired = zipRequired;
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets the active.
	 *
	 * @param isActive
	 *            the new active
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.common.entity.BaseEntity#id()
	 */
	@Override
	public Long id() {
		return countryId;
	}

}
