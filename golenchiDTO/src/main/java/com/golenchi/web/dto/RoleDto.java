/**
 * 
 */
package com.golenchi.web.dto;

import java.util.Set;

import lombok.Data;


public @Data class RoleDto {
	private Long id;
	private String description;
	private Long modifiedBy;
	private Long createdBy;
	private Long companyId;
	private String name;
	private Set<String> featureNames;	
}
