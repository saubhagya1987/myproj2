package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class DesignationDto {
	private Long id;
	private String name;
	private String description;
	private String companyCode;
	private Date dateAdded;
	private String addedBy;
	private Date modifyDate;
	private String modifiedBy;

}
