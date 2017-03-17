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
import com.golenchi.web.dto.SystemRolesDto;
import com.golenchi.web.repository.SystemRolesCrudrepository;
import com.golenchi.web.response.BaseResponse;
import com.golenchi.web.response.SystemRoleResponse;
import com.golenchi.web.service.SystemRolesService;
import com.golenchi.web.system.SystemRoles;

@Service
public class SystemRolesServiceImpl implements SystemRolesService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SystemRolesCrudrepository systemRolesCrudrepository;

	@Override
	public BaseResponse<?> addSystemRole(SystemRolesDto systemRolesDto) throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		SystemRoleResponse systemRoleResponse = new SystemRoleResponse();
		ResponseDto responseDto = null;
		SystemRoles systemRoles = null;
		try {
			systemRoles = modelMapper.map(systemRolesDto, SystemRoles.class);
			systemRolesCrudrepository.save(systemRoles);
			responseDto = new ResponseDto(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseCode(),
					ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseDescription());
		} catch (Exception exception) {
			// TODO: handle exception
			throw new BusinessException(ExceptionCodes.DUPLICATE_SYSTEM_ROLE);
		}
		systemRoleResponse.setResponseDto(responseDto);

		return systemRoleResponse;
	}

	@Override
	public BaseResponse<?> getSystemRolesList() throws SystemException, BusinessException {
		// TODO Auto-generated method stub
		List<SystemRolesDto> systemRolesDtoList = (List) systemRolesCrudrepository.findAll();

		SystemRoleResponse systemRoleResponse = new SystemRoleResponse();
		ResponseDto responseDto = new ResponseDto();
		responseDto.setResponseCode(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseCode());
		responseDto.setResponseDescription(ResponseCodes.SUCCESS_RESPONSE_CODE.getResponseDescription());
		systemRoleResponse.setResponseDto(responseDto);
		systemRoleResponse.setSystemRolesDtoList(systemRolesDtoList);

		return systemRoleResponse;
	}

}
