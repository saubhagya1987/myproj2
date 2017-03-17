package com.golenchi.web.common.constants;

public enum ResponseCodes {
	SUCCESS_RESPONSE_CODE(1001, "Success"), FAILURE_RESPONSE_CODE(1000, "Failure");
	private Integer responseCode;
	private String responseDescription;

	ResponseCodes(Integer responseCode, String responseDescription) {
		this.setResponseCode(responseCode);
		this.setResponseDescription(responseDescription);

	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}
}
