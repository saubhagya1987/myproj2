package com.golenchi.web.common;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.golenchi.web.user.Location;

import lombok.Data;

@Entity(name = "CALENDAR_YEAR")
public @Data class CalendarYear {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "calendar_year_id")
	private Long calendarYearId;
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "description", length = 225)
	private String description;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @ManyToOne(cascade = CascadeType.ALL)	
	private Location location;
	@Column(name = "date_added")
	private Date dateAdded;
	@Column(name = "added_by", length = 20)
	private String addedBy;
	@Column(name = "modify_date")
	private Date modifyDate;
	@Column(name = "modified_by", length = 20)
	private String modifiedBy;

}
