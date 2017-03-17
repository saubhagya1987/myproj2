/**
 * 
 */
package com.golenchi.web.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.golenchi.web.dto.GolenchiRequest;
import com.golenchi.web.dto.ResponseDto;
import com.golenchi.web.dto.RoleDto;
import com.golenchi.web.enums.Feature;
import com.golenchi.web.service.RoleManagementService;

/**
 * @author rahul
 *
 */
public class RoleManagementTestCases extends BaseSetUpEntity {

	@Autowired
	private RoleManagementService roleManagementService;

	@Test
	public void testCreateRole() {

		RoleDto roleDto = new RoleDto();
		roleDto.setCompanyId(1L);
		roleDto.setCreatedBy(1L);
		roleDto.setDescription("This role is used to login user");
		Set<String> featureName = new HashSet<String>();
		featureName.add(Feature.ADD_GROUP.getFeatureName());
		roleDto.setFeatureNames(featureName);
		roleDto.setModifiedBy(1L);
		roleDto.setName("ADD_GROUP");
		
		GolenchiRequest request = new GolenchiRequest();
		request.setRoleDto(roleDto);
		try{
		roleManagementService.createRole(roleDto);
//			ResponseDto expectedResponseResult = new ResponseDto(1, "success");
//			System.out.println("\n\n\n"+gson.toJson(request)+"\n\n\n\n");
//			sendRequest(gson.toJson(request), "/v1/addgroup", expectedResponseResult );
		}catch (Exception ex){
			ex.printStackTrace();
			//c77a35fc-ec0d-4e3a-b09a-573c63f9666a
		}

	}

}
