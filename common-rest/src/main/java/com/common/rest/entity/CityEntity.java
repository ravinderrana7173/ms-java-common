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
 * The Class CityEntity.
 */
@Entity
@Table(name = "com_city")
public class CityEntity extends BaseEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The city id. */
    @Id
    @Column(name = "city_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;

    /** The city name. */
    @Column(name = "city_name", length = 100, nullable = false)
    private String cityName;

    /** The state entity. */
    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateEntity stateEntity;

    /** The active. */
    @Column(name = "is_active", length = 1, nullable = false)
    private Boolean active;

    /**
     * Gets the city id.
     *
     * @return the city id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * Sets the city id.
     *
     * @param cityId the new city id
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * Gets the city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the city name.
     *
     * @param cityName the new city name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Gets the state entity.
     *
     * @return the state entity
     */
    public StateEntity getStateEntity() {
        return stateEntity;
    }

    /**
     * Sets the state entity.
     *
     * @param stateEntity the new state entity
     */
    public void setStateEntity(StateEntity stateEntity) {
        this.stateEntity = stateEntity;
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
     * @see com.common.rest.entity.BaseEntity#id()
     */
    @Override
    public Long id() {
        return cityId;
    }

}
