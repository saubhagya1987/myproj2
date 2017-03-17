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
import com.golenchi.web.feature.dto.FeaturesDto;
import com.golenchi.web.feature.dto.ModulesDto;
import com.golenchi.web.response.BaseResponse;
import com.golenchi.web.response.FeatureResponse;
import com.golenchi.web.response.ModuleResponse;
import com.golenchi.web.response.SystemRoleResponse;
import com.golenchi.web.service.FeaturesService;
import com.golenchi.web.service.ModuleService;
import com.golenchi.web.service.SystemRolesService;

@RestController
@RequestMapping("/v1")
public class MetaDataController {
	
	Logger LOGGER = LoggerFactory.getLogger(MetaDataController.class);

	@Autowired
	private FeaturesService featuresService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private SystemRolesService systemRolesService;

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/addModule", method = RequestMethod.POST)
	public BaseResponse<?> addModule(@RequestBody ModulesDto modulesDto) throws SystemException, BusinessException {
		ModuleResponse moduleResponse = (ModuleResponse) moduleService.addModule(modulesDto);
		return moduleResponse;
	}
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/addFeature", method = RequestMethod.POST)
	public BaseResponse<?> addFeature(@RequestBody FeaturesDto featuresDto) throws SystemException, BusinessException {
		FeatureResponse featureResponse =(FeatureResponse) featuresService.addFeature(featuresDto);
		return featureResponse;
	}
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/addSystemRole", method = RequestMethod.POST)
	public BaseResponse<?> addSystemRole(@RequestBody SystemRolesDto systemRolesDto) throws SystemException, BusinessException {
		SystemRoleResponse systemRoleResponse=(SystemRoleResponse) systemRolesService.addSystemRole(systemRolesDto);
		return systemRoleResponse;
	}
		
}
