package com.golenchi.web.service;

import java.util.List;

import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.feature.dto.FeaturesDto;
import com.golenchi.web.response.BaseResponse;

public interface FeaturesService {
	
	public BaseResponse<?> addFeature(FeaturesDto featuresDto) throws SystemException,BusinessException;
	public BaseResponse<?> getFeaturesListByModule(FeaturesDto featuresDto) throws SystemException,BusinessException;
	
	public FeaturesDto getFeaturesById(FeaturesDto featuresDto) throws SystemException,BusinessException;
	public List<FeaturesDto> getAllFeaturesList() throws SystemException,BusinessException;
	public FeaturesDto getByFeatureName(FeaturesDto featuresDto) throws SystemException,BusinessException;
	
}
