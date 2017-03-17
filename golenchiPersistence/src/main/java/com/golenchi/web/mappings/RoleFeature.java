package com.golenchi.web.mappings;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.golenchi.web.enums.Level;

import lombok.Data;

//@Entity(name = "ROLE_FEATURE")
public @Data class RoleFeature {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_feature_id")
	private Long roleFeatureId;
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "feature_id")
	private Long featureId;
	@Column(name = "read_permission")
	private Boolean readPermission;
	@Column(name = "write_permission")
	private Boolean writePermission;
	@Column(name = "level")
	private Level level;		
	@Column(name = "date_created")
	private Date dateCreated;
	@Column(name = "created_by")
	private Long createdBy;
	@Column(name = "date_modified")
	private Date dateModified;
	@Column(name = "modified_by")
	private Long modifiedBy;

}
