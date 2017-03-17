package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class ProductModulesDto {
	
	private Long id;
	private String moduleCode;
	private String moduleName;
	private String description;
	private String serviceType;
	private String endpointURL;
	private Date dateAdded;
	private String createdBy;
	private Date dateModified;
	private Long modifiedBy;

			
}
