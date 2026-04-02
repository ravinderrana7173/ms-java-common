package com.common.rest.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The Class SystemEntity.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "com_system")
public class SystemEntity extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The system id. */
	@Id
	@Column(name = "system_id", length = 11, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long systemId;

	/** The system uuid. */
	@Column(name = "system_uuid", length = 36, nullable = false)
	private String systemUuid;

	/** The system name. */
	@Column(name = "system_name", length = 100, nullable = false)
	private String systemName;

	/** The description. */
	@Column(name = "description", length = 500, nullable = true)
	private String description;

	
	
	/** The logo. */
	@Column(name = "system_code", length = 30, nullable = false)
	private String systemCode;
	
	/** The logo. */
	@Column(name = "is_simulation", length = 1)
	private Boolean isSimulation;

	/** The system capability entity. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "systemEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SystemCapabilityEntity> systemCapabilityEntity = new ArrayList<SystemCapabilityEntity>();

	/** The system capability details entity. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "systemEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SystemCapabilityDetailsEntity> systemCapabilityDetailsEntities;

	/**
	 * Id.
	 *
	 * @return the long
	 */
	@Override
	public Long id() {
		return systemId;
	}

}
