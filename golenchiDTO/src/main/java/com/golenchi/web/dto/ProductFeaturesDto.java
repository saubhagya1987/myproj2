package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class ProductFeaturesDto {
	private Long id;
	private String featureCode;
	private String featureName;
	private String moduleCode;
	private String description;
	private String serviceName;	
	private Date date_added;
	private Long createdBy;
	private Date dateModified;
	private Long modifiedBy;

}
