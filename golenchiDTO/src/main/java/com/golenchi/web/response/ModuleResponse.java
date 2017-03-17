package com.golenchi.web.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.golenchi.web.feature.dto.ModulesDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(value = Include.NON_NULL)
@EqualsAndHashCode(callSuper=false)
public @Data class ModuleResponse extends BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<ModulesDto> modulesDtoList;
	private ModulesDto modulesDto;
}
