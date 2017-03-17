package com.golenchi.web.common.utils;

import org.springframework.http.HttpStatus;

import com.golenchi.web.common.constants.ResponseCodes;
import com.golenchi.web.dto.ResponseDto;
import com.golenchi.web.response.BaseResponse;

public class GolenchiResponseUtils {
	public static <T> BaseResponse<T> getReefResponse(HttpStatus httpStatus) {
		BaseResponse<T> reefResponse = new BaseResponse<>();
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponseCode(httpStatus.value());
		responseDto.setResponseDescription(httpStatus.getReasonPhrase());
		reefResponse.setResponseDto(responseDto);
		return reefResponse;
	}

	public static <T> BaseResponse<T> getReefResponse(ResponseCodes responseCodes) {
		BaseResponse<T> reefResponse = new BaseResponse<>();
		
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponseCode(responseCodes.getResponseCode());
		responseDto.setResponseDescription(responseCodes.getResponseDescription());
		reefResponse.setResponseDto(responseDto);
		return reefResponse;
	}
}
