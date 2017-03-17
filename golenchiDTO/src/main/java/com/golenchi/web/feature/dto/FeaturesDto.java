package com.golenchi.web.feature.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_NULL)
public @Data class FeaturesDto{
	private Long featureId;
	private String featureName;
	private String description;
	private Boolean isDefault;
	private String featureHeader;
	private String featureType;
	private ModulesDto modules;
}
