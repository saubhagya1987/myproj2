
package com.golenchi.web.service;

import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.dto.SystemRolesDto;
import com.golenchi.web.response.BaseResponse;

public interface SystemRolesService {
	public BaseResponse<?> addSystemRole(SystemRolesDto systemRolesDto) throws SystemException,BusinessException;
	public BaseResponse<?> getSystemRolesList() throws SystemException,BusinessException;
}
