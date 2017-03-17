package com.golenchi.web.feature.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_NULL)
public @Data class ModulesDto {

	private Long moduleId;
	private String moduleName;
	private String description;
		
}
