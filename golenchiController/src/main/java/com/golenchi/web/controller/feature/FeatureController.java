package com.golenchi.web.controller.feature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.feature.dto.FeaturesDto;
import com.golenchi.web.response.BaseResponse;
import com.golenchi.web.response.FeatureResponse;
import com.golenchi.web.service.FeaturesService;

@RestController
@RequestMapping("/v1")
public class FeatureController {
	
	Logger LOGGER = LoggerFactory.getLogger(FeatureController.class);

	@Autowired
	private FeaturesService featuresService;

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/getFeature", method = RequestMethod.POST)
	public BaseResponse<?> getFeature(@RequestBody FeaturesDto featuresDto) throws SystemException, BusinessException {
		FeatureResponse featureResponse = (FeatureResponse) featuresService.getFeaturesListByModule(featuresDto);
		return featureResponse;
	}
}
