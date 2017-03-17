package com.golenchi.web.orgs;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

//@Entity(name = "DEPARTMENT")
public @Data class Department {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private Long departmentId;
	@Column(name = "name", length = 20, unique = true)
	private String name;
	@Column(name = "description")
	private String description;
	@JoinColumn(name = "company_code", referencedColumnName = "company_code")
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	@Column(name = "date_added")
	private Date dateAdded;
	@Column(name = "added_by", length = 20)
	private String addedBy;
	@Column(name = "modify_date")
	private Date modifyDate;
	@Column(name = "modified_by", length = 20)
	private String modifiedBy;

}
