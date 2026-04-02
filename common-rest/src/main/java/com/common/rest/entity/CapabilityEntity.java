package com.common.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class CapabilityEntity.
 */
@Entity

/**
 * Instantiates a new capability entity.
 */
@Data

/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "com_capability")
public class CapabilityEntity extends BaseEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;


    /** The capability id. */
    @Id
    @Column(name = "capability_id", length = 11, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long capabilityId;


    /** The capability code. */
    @Column(name = "capability_code", length = 10, nullable = false)
    private String capabilityCode;


    /** The capability name. */
    @Column(name = "capability_name", length = 100, nullable = false)
    private String capabilityName;

    /** The description. */
    @Column(name = "description", length = 500, nullable = true)
    private String description;

    /**
     * Id.
     *
     * @return the long
     */
    @Override
    public Long id() {
        return capabilityId;
    }



}
