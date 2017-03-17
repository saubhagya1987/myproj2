package com.golenchi.web.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golenchi.web.common.constants.ErrorCodes;
import com.golenchi.web.common.constants.ExceptionCodes;
import com.golenchi.web.common.constants.ResponseCodes;
import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.dto.ResponseDto;
import com.golenchi.web.feature.dto.FeaturesDto;
import com.golenchi.web.product.Features;
import com.golenchi.web.product.Modules;
import com.golenchi.web.repository.FeaturesCrudrepository;
import com.golenchi.web.repository.ModulesCrudrepository;
import com.golenchi.web.response.BaseResponse;
import com.golenchi.web.response.FeatureResponse;
import com.golenchi.web.service.FeaturesService;

@Service
public class FeatureServiceImpl implements FeaturesService {

	@Autowired
	private FeaturesCrudrepository featuresCrudrepository;

	@Autowired
	private ModulesCrudrepository modulesCrudrepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseResponse<?> addFeature(FeaturesDto featuresDto) throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		Modules modules = null;
		modules = modulesCrudrepository.findOne(featuresDto.getModules().getModuleId());
		if (modules == null)
			throw new BusinessException(ErrorCodes.MODULE_ID_NOT_EXIST);

		FeatureResponse featureResponse = new FeatureResponse();
		Features features = null;
		ResponseDto responseDto = null;
		try {
			features = modelMapper.map(featuresDto, Features.class);
			features.setModules(modules);
			featuresCrudrepository.save(features);
			responseDto = new ResponseDto(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseCode(),
					ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseDescription());
		} catch (Exception exception) {
			// TODO: handle exception
			throw new BusinessException(ExceptionCodes.DUPLICATE_FEATURE_NAME);
		}

		featureResponse.setResponseDto(responseDto);

		return featureResponse;

	}

	@Override
	public BaseResponse<?> getFeaturesListByModule(FeaturesDto featuresDto) throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		Features features = modelMapper.map(featuresDto, Features.class);
		List<FeaturesDto> featuresList = (List) featuresCrudrepository.findByModules(features.getModules());
		FeatureResponse featureResponse = new FeatureResponse();
		ResponseDto responseDto = new ResponseDto(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseCode(),
				ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseDescription());
		featureResponse.setResponseDto(responseDto);
		featureResponse.setFeaturesDtoList(featuresList);
		return featureResponse;
	}

	@Override
	public FeaturesDto getFeaturesById(FeaturesDto featureDto) throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		Features features = featuresCrudrepository.findOne(featureDto.getFeatureId());
		FeaturesDto featuresDto = modelMapper.map(features, FeaturesDto.class);
		return featuresDto;
	}

	@Override
	public List<FeaturesDto> getAllFeaturesList() throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		List<FeaturesDto> featuresList = (List) featuresCrudrepository.findAll();
		return featuresList;
	}

	@Override
	public FeaturesDto getByFeatureName(FeaturesDto featureDto) throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		Features features = featuresCrudrepository.findByFeatureName(featureDto.getFeatureName());
		FeaturesDto featuresDto = modelMapper.map(features, FeaturesDto.class);
		return featuresDto;
	}

}
