package com.golenchi.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_NULL)
public @Data class GolenchiRequest {
	private RoleDto roleDto;
	private CompanyDto companyDto;
	private UserDto userDto;
	
}
