package com.golenchi.web.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golenchi.web.common.constants.ExceptionCodes;
import com.golenchi.web.common.constants.ResponseCodes;
import com.golenchi.web.common.exception.BusinessException;
import com.golenchi.web.common.exception.SystemException;
import com.golenchi.web.dto.ResponseDto;
import com.golenchi.web.feature.dto.ModulesDto;
import com.golenchi.web.product.Modules;
import com.golenchi.web.repository.ModulesCrudrepository;
import com.golenchi.web.response.BaseResponse;
import com.golenchi.web.response.GolenchiResponse;
import com.golenchi.web.response.ModuleResponse;
import com.golenchi.web.service.ModuleService;
import com.golenchi.web.system.SystemRoles;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModulesCrudrepository modulesCrudrepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BaseResponse<?> addModule(ModulesDto modulesDto) throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		ModuleResponse moduleResponse = new ModuleResponse();
		ResponseDto responseDto = null;
		Modules modules = null;
		try {
			modules = modelMapper.map(modulesDto, Modules.class);
			modulesCrudrepository.save(modules);
			responseDto = new ResponseDto(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseCode(),
					ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseDescription());
		} catch (Exception exception) {
			// TODO: handle exception
			throw new BusinessException(ExceptionCodes.DUPLICATE_MODULE_NAME);
		}
		moduleResponse.setResponseDto(responseDto);

		return moduleResponse;

	}

	@Override
	public BaseResponse<?> getModuleList() throws SystemException, BusinessException {
		// TODO Auto-generated method stub

		List<ModulesDto> moduleList = (List) modulesCrudrepository.findAll();

		ModuleResponse moduleResponse = new ModuleResponse();
		ResponseDto responseDto = new ResponseDto();

		responseDto.setResponseCode(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseCode());
		responseDto.setResponseDescription(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseDescription());

		moduleResponse.setResponseDto(responseDto);
		moduleResponse.setModulesDtoList(moduleList);

		return moduleResponse;
	}

	@Override
	public ModulesDto getModuleById(ModulesDto modulesDto) throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		Modules modules = modulesCrudrepository.findOne(modulesDto.getModuleId());
		ModulesDto mdodulesDto = modelMapper.map(modules, ModulesDto.class);
		return mdodulesDto;
	}

	@Override
	public ModulesDto getModuleByName(ModulesDto modulesDto) throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		Modules modules = modulesCrudrepository.findByModuleName(modulesDto.getModuleName());
		ModulesDto mdodulesDto = modelMapper.map(modules, ModulesDto.class);
		return mdodulesDto;
	}

}
