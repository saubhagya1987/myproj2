/**
 * 
 */
package com.golenchi.web.service;

import com.golenchi.web.dto.RoleDto;

/**
 * @author rahul
 *
 */
public interface RoleManagementService {

	/**
	 * @param dto
	 */
	void createRole(RoleDto dto);

	/**
	 * @param dto
	 */
	void editRole(RoleDto dto);

}
