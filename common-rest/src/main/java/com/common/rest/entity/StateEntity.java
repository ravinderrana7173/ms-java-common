package com.common.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The Class StatesEntity.
 */

@Entity
@Table(name = "com_state")
public class StateEntity extends BaseEntity {


    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The state id. */
    @Id
    @Column(name = "state_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stateId;

    /** The state code. */
    @Column(name = "state_code", length = 20, nullable = false)
    private String stateCode;

    /** The state name. */
    @Column(name = "state_name", length = 100, nullable = false)
    private String stateName;

    /** The country entity. */
    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

    /** The is active. */
    @Column(name = "is_active", length = 1, nullable = false)
    private Boolean active;



    /**
     * Gets the state id.
     *
     * @return the state id
     */
    public Long getStateId() {
        return stateId;
    }



    /**
     * Sets the state id.
     *
     * @param stateId the new state id
     */
    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }



    /**
     * Gets the state code.
     *
     * @return the state code
     */
    public String getStateCode() {
        return stateCode;
    }



    /**
     * Sets the state code.
     *
     * @param stateCode the new state code
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }



    /**
     * Gets the state name.
     *
     * @return the state name
     */
    public String getStateName() {
        return stateName;
    }



    /**
     * Sets the state name.
     *
     * @param stateName the new state name
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }





    /**
     * Gets the country entity.
     *
     * @return the country entity
     */
    public CountryEntity getCountryEntity() {
        return countryEntity;
    }



    /**
     * Sets the country entity.
     *
     * @param countryEntity the new country entity
     */
    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }


    /**
     * Gets the active.
     *
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }



    /**
     * Sets the active.
     *
     * @param active the new active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }



    /* (non-Javadoc)
     * @see com.common.entity.BaseEntity#id()
     */
    @Override
    public Long id() {
        return stateId;
    }

}
