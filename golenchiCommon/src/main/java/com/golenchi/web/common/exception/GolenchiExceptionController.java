package com.golenchi.web.common.exception;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golenchi.web.common.constants.ExceptionCodes;
import com.golenchi.web.common.constants.ResponseCodes;
import com.golenchi.web.dto.ResponseDto;
import com.golenchi.web.response.GolenchiResponse;

@ControllerAdvice
public class GolenchiExceptionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GolenchiExceptionController.class);
	
	@ExceptionHandler(value = BusinessException.class)
	public @ResponseBody GolenchiResponse handleBusinessException(BusinessException businessException){
		LOGGER.error("BUSINESS EXCEPTION : "+ExceptionUtils.getStackTrace(businessException));
		GolenchiResponse golenchiResponse = new GolenchiResponse();
		ResponseDto responseDto =new ResponseDto();
		responseDto.setResponseCode(ResponseCodes.FAILURE_RESPONSE_CODE.getResponseCode());
		responseDto.setResponseDescription(ResponseCodes.FAILURE_RESPONSE_CODE.getResponseDescription());
		responseDto.setExceptionCode(businessException.getExceptionCode());
		responseDto.setExceptionDescription(businessException.getExceptionMessage());
		golenchiResponse.setResponseDto(responseDto);
		return golenchiResponse;		
	}
	
	@ExceptionHandler(value = SystemException.class)
	public @ResponseBody GolenchiResponse handleSystemException(SystemException systemException){
		
		LOGGER.error("SYSTEM EXCEPTION : "+ExceptionUtils.getStackTrace(systemException));
		GolenchiResponse golenchiResponse = new GolenchiResponse();
		ResponseDto responseDto =new ResponseDto();
		responseDto.setResponseCode(ResponseCodes.FAILURE_RESPONSE_CODE.getResponseCode());
		responseDto.setResponseDescription(ResponseCodes.FAILURE_RESPONSE_CODE.getResponseDescription());
		responseDto.setExceptionCode(ExceptionCodes.SYSTEM_EXCEPTION.getExceptionCode());
		responseDto.setExceptionDescription(ExceptionCodes.SYSTEM_EXCEPTION.getExceptionDescription());
		golenchiResponse.setResponseDto(responseDto);
		return golenchiResponse;	
	}
}
