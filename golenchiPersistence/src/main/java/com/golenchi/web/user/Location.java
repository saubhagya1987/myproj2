package com.golenchi.web.user;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.golenchi.web.orgs.Company;

import lombok.Data;

@Entity(name = "LOCATION")
public @Data class Location {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private Long locationId;
	@Column(name = "location_code", length = 20, unique = true)
	private String locationCode;
	@Column(name = "name", length = 20)
	private String name;
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Company company;
	@Column(name = "description")
	private String description;
	@Column(name = "address", length = 200)
	private String address;
	@Column(name = "country", length = 100)
	private String country;
	@Column(name = "city", length = 100)
	private String city;
	@Column(name = "state", length = 100)
	private String state;
	@Column(name = "zip_code")
	private Integer zip_code;
	@Column(name = "date_added")
	private Date dateAdded;
	@Column(name = "added_by", length = 20)
	private String addedBy;
	@Column(name = "modify_date")
	private Date modifyDate;
	@Column(name = "modified_by", length = 20)
	private String modifiedBy;

}
