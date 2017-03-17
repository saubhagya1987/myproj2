package com.golenchi.web.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.golenchi.web.dto.CompanyDto;
import com.golenchi.web.dto.UserDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(value = Include.NON_NULL)
@EqualsAndHashCode(callSuper=false)
public @Data class GolenchiResponse extends BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private CompanyDto companyDto;
	private UserDto userDto;
	
}
