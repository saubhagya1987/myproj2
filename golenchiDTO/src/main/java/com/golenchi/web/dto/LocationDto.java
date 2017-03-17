package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class LocationDto {
	private Long id;
	private String locationCode;
	private String name;
	private String companyCode;
	private String description;
	private Date dateAdded;
	private String addedBy;
	private Date modifyDate;
	private String modifiedBy;

}
