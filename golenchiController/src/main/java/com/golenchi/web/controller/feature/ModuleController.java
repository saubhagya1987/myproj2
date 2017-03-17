package com.golenchi.web.controller.feature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.response.BaseResponse;
import com.golenchi.web.response.ModuleResponse;
import com.golenchi.web.service.ModuleService;

@RestController
@RequestMapping("/v1")
public class ModuleController {
	
	Logger LOGGER = LoggerFactory.getLogger(ModuleController.class);

	@Autowired
	private ModuleService moduleService;
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/getModule", method = RequestMethod.POST)
	public BaseResponse<?> getModules() throws SystemException, BusinessException {
		ModuleResponse moduleResponse = (ModuleResponse) moduleService.getModuleList();
		return moduleResponse;
	}

}
