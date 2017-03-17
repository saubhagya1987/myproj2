package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class CalendarYearDto {
	private Long id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private String locationCode;
	private Date dateAdded;
	private String addedBy;
	private Date modifyDate;
	private String modifiedBy;

}
