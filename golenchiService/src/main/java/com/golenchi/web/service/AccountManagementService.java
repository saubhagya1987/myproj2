package com.golenchi.web.service;

import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.dto.GolenchiRequest;
import com.golenchi.web.response.GolenchiResponse;

public interface AccountManagementService {
	
	public GolenchiResponse addCompany(GolenchiRequest golenchiRequest) throws BusinessException,SystemException;
	public GolenchiResponse resendVerificationCode(GolenchiRequest golenchiRequest) throws BusinessException,SystemException;
	public GolenchiResponse verifyUniqueOrgCode(GolenchiRequest golenchiRequest) throws BusinessException,SystemException;
	public GolenchiResponse verifyUniqueCompanyEmail(GolenchiRequest golenchiRequest) throws BusinessException,SystemException;
	
}
