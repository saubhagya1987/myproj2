package com.golenchi.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.dto.SystemRolesDto;
import com.golenchi.web.response.BaseResponse;
import com.golenchi.web.response.SystemRoleResponse;
import com.golenchi.web.service.SystemRolesService;

@RestController
@RequestMapping("/v1")
public class SystemRolesController {
	
	Logger LOGGER = LoggerFactory.getLogger(SystemRolesController.class);

	@Autowired
	private SystemRolesService systemRolesService;

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/getSystemRole", method = RequestMethod.POST)
	public BaseResponse<?> getSystemRoles(@RequestBody SystemRolesDto systemRolesDto) throws SystemException, BusinessException {
		SystemRoleResponse systemRoleResponse=(SystemRoleResponse) systemRolesService.getSystemRolesList();
		return systemRoleResponse;
	}
		
}
