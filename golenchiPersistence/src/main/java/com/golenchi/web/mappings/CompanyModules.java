package com.golenchi.web.mappings;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "COMPANY_MODULES")
public @Data class CompanyModules {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_module_id")
	private Long companyModuleId;
	@Column(name = "company_id", length = 20)
	private String companyId;
	@Column(name = "module_id", length = 20)
	private String moduleId;
	@Column(name = "date_added")
	private Date dateAdded;

}
