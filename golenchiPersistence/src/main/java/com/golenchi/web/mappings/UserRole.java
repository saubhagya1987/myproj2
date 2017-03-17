/*package com.golenchi.web.mappings;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.golenchi.web.enums.Status;

import lombok.Data;

//@Entity(name = "USER_ROLE")
public @Data class UserRole {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id")
	private Long userRoleId;	
	@Column(name = "user_id")
	private	Long userId;	
	@Column(name = "role_id")
	private	Long roleId;	
	@Column(name = "status")
	private	Status status;	
	@Column(name = "date_added")
	private	Date dateAdded;	
	@Column(name = "assigned_by")
	private	Long assignedBy;	
	@Column(name = "date_modified")
	private	Date dateModified;	
	@Column(name = "modified_by")
	private	Long modifiedBy;	

}
*/