package com.golenchi.web.service;

import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.feature.dto.ModulesDto;
import com.golenchi.web.response.BaseResponse;

public interface ModuleService {
	public BaseResponse<?> addModule(ModulesDto modulesDto) throws SystemException,BusinessException;
	public BaseResponse<?> getModuleList() throws SystemException,BusinessException;
	public ModulesDto getModuleById(ModulesDto modulesDto) throws SystemException,BusinessException;
	public ModulesDto getModuleByName(ModulesDto modulesDto) throws SystemException,BusinessException;
}
