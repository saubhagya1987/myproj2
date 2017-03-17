package com.golenchi.web.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.golenchi.web.dto.ResponseDto;

import lombok.Data;

@JsonInclude(value = Include.NON_NULL)
public @Data class BaseResponse<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ResponseDto responseDto;
	private T body;

}
