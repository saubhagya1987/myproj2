package com.golenchi.web.common.constants;

public enum ExceptionCodes {
	
	SYSTEM_EXCEPTION(103,"System exception occurs."),
	BUSINESS_EXCEPTION(104,"Business exception occurr."),
	DUPLICATE_COMPANY_CODE(105,"Company Code already exist."),
	DUPLICATE_SYSTEM_ROLE(106,"System ROLE already exist."),
	DUPLICATE_MODULE_NAME(107,"Module Name already exist."),
	DUPLICATE_FEATURE_NAME(108,"Feature Name already exist in same Module.")
	;
	
	private final Integer exceptionCode;
	private final String exceptionDescription;

	private ExceptionCodes(int exceptionCode, String exceptionDescription) {
		this.exceptionCode = exceptionCode;
		this.exceptionDescription = exceptionDescription;
	}

	public Integer getExceptionCode() {
		return this.exceptionCode;
	}

	public String getExceptionDescription() {
		return exceptionDescription;
	}
}