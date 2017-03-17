package com.golenchi.web.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.golenchi.web.common.BaseDomain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "SYSTEM_ROLES")
@EqualsAndHashCode(callSuper=false)
public @Data class SystemRoles extends BaseDomain {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "system_roles_id")
	private Long systemRolesId;
	@Column(name = "name", length = 50,unique=true, nullable=false)
	private String name;
	@Column(name = "description", length = 200)
	private String description;
}
