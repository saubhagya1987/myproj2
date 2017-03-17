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
import com.golenchi.web.dto.GolenchiRequest;
import com.golenchi.web.dto.ResponseDto;
import com.golenchi.web.response.GolenchiResponse;
import com.golenchi.web.service.RoleManagementService;

@RestController
@RequestMapping("/v1")
public class RoleManagementController {
	
	Logger LOGGER = LoggerFactory.getLogger(RoleManagementController.class);

	@Autowired
	private RoleManagementService accountManagementService;

	@PreAuthorize("hasRole('ADD_GROUP')")
	@RequestMapping(value = "/addgroup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public GolenchiResponse addGroup(@RequestBody GolenchiRequest golenchiRequest) throws SystemException, BusinessException {
		accountManagementService.createRole(golenchiRequest.getRoleDto());// (golenchiRequest);
		GolenchiResponse golenchiResponse = new GolenchiResponse();
		ResponseDto dto = new ResponseDto(1, "success");
		golenchiResponse.setResponseDto(dto);
		return golenchiResponse;
	}

}
