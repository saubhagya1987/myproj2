package com.golenchi.web.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value=Include.NON_NULL)
public @Data class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Long companyId;
	private String roles;	
	private Status status;
	private Date dateCreated;
	private Long created_by;
	private Date dateModified;
	private Long modifiedBy;

}
