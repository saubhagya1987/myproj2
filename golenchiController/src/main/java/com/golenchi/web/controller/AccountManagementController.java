package com.golenchi.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.dto.GolenchiRequest;
import com.golenchi.web.response.GolenchiResponse;
import com.golenchi.web.service.AccountManagementService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/accountManagement")
public class AccountManagementController {
	
	Logger LOGGER = LoggerFactory.getLogger(AccountManagementController.class);

	@Autowired
	AccountManagementService accountManagementService;
	
	@Autowired
	Gson gson;
	
	@RequestMapping(value = "/addCompany",method  = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody GolenchiResponse addCompany(@RequestBody GolenchiRequest golenchiRequest) throws BusinessException, SystemException{
		LOGGER.info(gson.toJson(golenchiRequest));
		GolenchiResponse golenchiResponse = accountManagementService.addCompany(golenchiRequest);
		LOGGER.info("********************************************************************************************");
		return golenchiResponse;
	}
	
	@RequestMapping(value = "/resendVerificationCode", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public GolenchiResponse resendVerificationCode(@RequestBody GolenchiRequest golenchiRequest) throws BusinessException, SystemException{		
		GolenchiResponse golenchiResponse = accountManagementService.resendVerificationCode(golenchiRequest);
		return golenchiResponse;		
	}
	
	@RequestMapping(value = "/verifyUniqueOrgCode", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public GolenchiResponse verifyUniqueOrgCode(@RequestBody GolenchiRequest golenchiRequest) throws BusinessException, SystemException{
		GolenchiResponse golenchiResponse = accountManagementService.verifyUniqueOrgCode(golenchiRequest);
		return golenchiResponse;		
	}
	
	@RequestMapping(value = "/verifyUniqueCompEmail", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public GolenchiResponse verifyUniqueCompanyEmail(@RequestBody GolenchiRequest golenchiRequest) throws BusinessException, SystemException{
		GolenchiResponse golenchiResponse = accountManagementService.verifyUniqueCompanyEmail(golenchiRequest);
		return golenchiResponse;		
	}

}
