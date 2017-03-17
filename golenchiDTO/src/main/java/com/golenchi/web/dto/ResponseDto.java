package com.golenchi.web.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_NULL)
public @Data class ResponseDto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private int responseCode;
	private String responseDescription;
	private int exceptionCode;
	private String exceptionDescription;
	
	public ResponseDto(int responseCode, String responseDescription) {
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
	}
	public ResponseDto() {
		// TODO Auto-generated constructor stub
	}
}
