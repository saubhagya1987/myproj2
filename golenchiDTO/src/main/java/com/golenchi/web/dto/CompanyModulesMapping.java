package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class CompanyModulesMapping {
	private Long id;
	private String companyCode;
	private String moduleCode;
	private Date dateAdded;

}
