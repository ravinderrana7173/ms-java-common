package com.common.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class SystemCapabilityDetailsEntity.
 */
@Entity

/**
 * Instantiates a new system capability details entity.
 */
@Data

/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "com_system_capability_details")
public class SystemCapabilityDetailsEntity  extends BaseEntity {

	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The systemcapability detail id. */
    @Id
    @Column(name = "system_capability_detail_id", length = 11, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemcapabilityDetailId;

    /** The capability entity. */
    @ManyToOne
    @JoinColumn(name = "capability_id")
    private CapabilityEntity capabilityEntity;

    /** The system entity. */
    @ManyToOne
    @JoinColumn(name = "system_id",nullable = false)
    private SystemEntity systemEntity;
    
    /** The key. */
    @Column(name = "key", length = 50, nullable = false)
    private String key;
    
    /** The value. */
    @Column(name = "value", length = 50, nullable = false)
    private String value;
    
    /**
     * Id.
     *
     * @return the long
     */
    @Override
    public Long id() {
        return systemcapabilityDetailId;
    }

}
