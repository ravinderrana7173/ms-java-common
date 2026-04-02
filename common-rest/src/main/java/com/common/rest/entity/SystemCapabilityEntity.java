package com.common.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class CityEntity.
 */
@Entity

/**
 * Instantiates a new system capability entity.
 */
@Data

/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "com_system_capability")
public class SystemCapabilityEntity extends BaseEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;


    /** The systemcapability id. */
    @Id
    @Column(name = "system_capability_id", length = 11, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemcapabilityId;

    /** The capability entity. */
    @ManyToOne
    @JoinColumn(name = "capability_id")
    private CapabilityEntity capabilityEntity;

    /** The system entity. */
    @ManyToOne
    @JoinColumn(name = "system_id")
    private SystemEntity systemEntity;

    /**
     * Id.
     *
     * @return the long
     */
    @Override
    public Long id() {
        return systemcapabilityId;
    }

}
