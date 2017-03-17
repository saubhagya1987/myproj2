package com.golenchi.web.common.constants;

public enum ErrorCodes {
	EMAIL_ALREADY_EXITS(901,"Email Id already exits"),
	MODULE_ID_NOT_EXIST(902,"Module id not exits.")
	;
	private Integer erorCode;
    private String ErrorDescription;
	ErrorCodes(Integer erorCode, String ErrorDescription){
		this.setErrorCode(erorCode);
		this.setErrorDescription(ErrorDescription);
		
	}
	public Integer getErrorCode() {
		return erorCode;
	}
	public void setErrorCode(Integer responseCode) {
		this.erorCode = responseCode;
	}
	public String getErrorDescription() {
		return ErrorDescription;
	}
	public void setErrorDescription(String responseDescription) {
		this.ErrorDescription = responseDescription;
	}
}
