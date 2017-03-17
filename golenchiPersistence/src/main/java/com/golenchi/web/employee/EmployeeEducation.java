package com.golenchi.web.employee;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.golenchi.web.enums.HighestEducation;
import com.golenchi.web.orgs.Company;

import lombok.Data;

//@Entity(name = "EMPLOYEE_EDUCATION")
public @Data class EmployeeEducation {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_education_id")
	private Long employeeEducationId;
	@Column(name = "institute_name", length = 255)
	private	String instituteName;	
	@Column(name = "highest_education")
	private	HighestEducation highestEducation;	
	@Column(name = "field_of_study", length = 100)
	private	String fieldOfStudy;	
	@Column(name = "date_of_completion")
	private	Date dateOfCompletion;	
	@Column(name = "additional_notes", length = 255)
	private	String additionalNotes;	
	@Column(name = "date_added")
	private	Date dateAdded;	
	@Column(name = "added_by", length = 20)
	private	String addedBy;	
	@Column(name = "modify_date")
	private	Date modifyDate;	
	@Column(name = "modified_by", length = 20)
	private	String modifiedBy;	
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Company company;	//foreign Key from employee table
	@JoinColumn(name = "emp_code", referencedColumnName = "emp_code")
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;	//foreign Key from employee table
}
