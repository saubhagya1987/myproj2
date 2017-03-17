package com.golenchi.web.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.golenchi.web.common.BaseDomain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "MODULES")
@EqualsAndHashCode(callSuper=false)
public @Data class Modules extends BaseDomain {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "module_id")
	private Long moduleId;
	
	@Column(name = "module_name", length = 50,unique=true, nullable=false)
	private String moduleName;
	
	@Column(name = "description", length = 200)
	private String description;
		
}
