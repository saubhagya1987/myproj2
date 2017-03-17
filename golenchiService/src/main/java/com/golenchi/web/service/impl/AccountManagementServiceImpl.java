package com.golenchi.web.service.impl;

import java.util.Date;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.ireslab.notification.bean.MailUser;
import org.ireslab.notification.service.MailService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.golenchi.web.common.constants.ErrorCodes;
import com.golenchi.web.common.constants.ResponseCodes;
import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.common.utils.MaskUtils;
import com.golenchi.web.dao.AccountManagementDao;
import com.golenchi.web.dao.UserManagementDao;
import com.golenchi.web.dao.UserVerificationDao;
import com.golenchi.web.dto.CompanyDto;
import com.golenchi.web.dto.GolenchiRequest;
import com.golenchi.web.dto.ResponseDto;
import com.golenchi.web.dto.UserDto;
import com.golenchi.web.enums.Status;
import com.golenchi.web.orgs.Company;
import com.golenchi.web.response.GolenchiResponse;
import com.golenchi.web.service.AccountManagementService;
import com.golenchi.web.user.User;
import com.golenchi.web.user.UserVerification;
@Component
public class AccountManagementServiceImpl implements AccountManagementService{
	
	Logger LOGGER = LoggerFactory.getLogger(AccountManagementServiceImpl.class);
	
	/*@Autowired
	GenericDao<BaseDomain> genericDao;*/
	
	@Autowired
	AccountManagementDao accountManagementDao;
	@Autowired
	UserManagementDao userManagementDao;
	@Autowired
	UserVerificationDao userVerificationDao;
	
	
	MailService mailService = new MailService() {
		
		@Override
		public void sendEmail(MailUser user) {
			// TODO Auto-generated method stub
			
		}
	};
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public GolenchiResponse addCompany(GolenchiRequest golenchiRequest) {
		Company company = new Company();
		User user = new User();
		GolenchiResponse golenchiResponse = new GolenchiResponse();
		if(null != golenchiRequest){
			if(null != golenchiRequest.getCompanyDto()){
				LOGGER.info("Adding Company " + golenchiRequest.getCompanyDto().getCompanyName());
				company = modelMapper.map(golenchiRequest.getCompanyDto(), Company.class);
				company.setCreatedBy(-1);
				company.setModifiedBy(-1);
				company.setDateModified(new Date());
				company.setDateAdded(new Date());
				company = (Company)accountManagementDao.merge(company);
				CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);
				golenchiResponse.setCompanyDto(companyDto);
			}
			if(null != golenchiRequest.getUserDto()){
				LOGGER.info("Adding User " + golenchiRequest.getUserDto().getFirstName());
				user = modelMapper.map(golenchiRequest.getUserDto(), User.class);
				user.setCompany(company);
				user.setCreatedBy(-1);
				user.setModifiedBy(-1);
				user.setStatus(Status.PENDING);
				user.setDateModified(new Date());
				user.setDateAdded(new Date());
				user = (User)userManagementDao.merge(user);
				UserDto userDto = modelMapper.map(user, UserDto.class);
				golenchiResponse.setUserDto(userDto);								
			}
			saveUserVerification(company, user, "save");
		}		
		ResponseDto responseDto = new ResponseDto(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseCode(), ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseDescription());
		golenchiResponse.setResponseDto(responseDto);
		LOGGER.info("Account Signup has been completed");
				
		return golenchiResponse;
	}
	
	@Override
	public GolenchiResponse resendVerificationCode(GolenchiRequest golenchiRequest) {
		Company company = modelMapper.map(golenchiRequest, Company.class);
		saveUserVerification(company, null, "resend");
		return null;
	}
	
	private UserVerification saveUserVerification(Company company, User user, String sendingType){
		UserVerification userVerification = new UserVerification();
		String verificationCode = MaskUtils.generateSecurityCode();
		userVerification.setVerificationCode(verificationCode);
		userVerification.setEmailAddress(company.getEmailAddress());
		userVerification.setMobileNo(company.getContactNumber1());
		userVerification.setModifiedBy(-1);
		if(!sendingType.equalsIgnoreCase("resend")){
			userVerification.setCompany(company);
			userVerification.setUser(user);
			userVerification.setDateAdded(new Date());
		}
		userVerification.setDateModified(new Date());		
		userVerification = (UserVerification)userVerificationDao.merge(userVerification);
		MailUser mailUser = new MailUser();
		mailUser.setUserActivationCode(verificationCode);
		mailUser.setEmailAddress(company.getEmailAddress());
		mailUser.setUserName(company.getCompanyName());
		mailService.sendEmail(mailUser);
		return userVerification;
		
	}

	@Override
	public GolenchiResponse verifyUniqueOrgCode(GolenchiRequest golenchiRequest) throws BusinessException, SystemException {
		//genericDao.findResultsByNameQuery(queryName, fieldValue);		
		return null;
	}

	@Override
	public GolenchiResponse verifyUniqueCompanyEmail(GolenchiRequest golenchiRequest) throws BusinessException,
		SystemException {
		GolenchiResponse golenchiResponse = new GolenchiResponse();
		Map<String,Object> param = new HashedMap(1);
		param.put("emailAddress",golenchiRequest.getCompanyDto().getEmailAddress());
		Company company= accountManagementDao.findSingleResultByNameQuery("Company.findByEmail", param);
		LOGGER.info("company from verifyUniqueCompanyEmail "+company);
				if(company != null){
					ResponseDto responseDto = new ResponseDto(ErrorCodes.EMAIL_ALREADY_EXITS.getErrorCode(), ErrorCodes.EMAIL_ALREADY_EXITS.getErrorDescription());
					golenchiResponse.setResponseDto(responseDto);
					return golenchiResponse;
				}
		ResponseDto responseDto = new ResponseDto(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseCode(), ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseDescription());
		golenchiResponse.setResponseDto(responseDto);
		return golenchiResponse;
	}

	
}
