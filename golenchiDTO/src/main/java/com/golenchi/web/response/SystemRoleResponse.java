package com.golenchi.web.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.golenchi.web.dto.SystemRolesDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(value = Include.NON_NULL)
@EqualsAndHashCode(callSuper=false)
public @Data class SystemRoleResponse extends BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<SystemRolesDto> systemRolesDtoList;
	private SystemRolesDto systemRolesDto;
}
