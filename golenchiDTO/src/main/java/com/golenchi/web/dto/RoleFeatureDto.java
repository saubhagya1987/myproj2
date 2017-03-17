package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class RoleFeatureDto {
	private Long id;
	private Long roleId;
	private Long featureId;
	private Boolean readPermission;
	private Boolean writePermission;
	private Level level;		
	private Date dateCreated;
	private Long createdBy;
	private Date dateModified;
	private Long modifiedBy;

}
