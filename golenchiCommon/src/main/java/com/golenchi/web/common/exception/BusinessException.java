package com.golenchi.web.common.exception;

import com.golenchi.web.common.constants.ErrorCodes;
import com.golenchi.web.common.constants.ExceptionCodes;

import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = false)
public @Data class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	private Integer exceptionCode;
	private String exceptionMessage;

	public BusinessException() {
	}

	public BusinessException(ExceptionCodes exceptionCodes) {
		super(exceptionCodes.getExceptionDescription());
		this.setExceptionCode(exceptionCodes.getExceptionCode());
		this.setExceptionMessage(exceptionCodes.getExceptionDescription());
	}
	
	public BusinessException(ErrorCodes errorCodes) {
		super(errorCodes.getErrorDescription());
		this.setExceptionCode(errorCodes.getErrorCode());
		this.setExceptionMessage(errorCodes.getErrorDescription());
	}
	
	public BusinessException(String s, Throwable throwable) {
		super(s, throwable);
	}
	public BusinessException(Throwable throwable) {
		super(throwable);
	}
}