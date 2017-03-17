package com.golenchi.web.employee;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

//@Entity(name = "EMPLOYEE_SKILL_SET")
public @Data class EmployeeSkillSet {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private Integer skillId;
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;
	@Column(name = "primary_skills")
	private	String primarySkills;	
	@Column(name = "secondary_skills")
	private	String secondarySkills;	
	@Column(name = "primary_domain", length = 100)
	private	String primaryDomain;	
	@Column(name = "secondary_domain", length = 100)
	private	String secondDomain;	
	@Column(name = "date_added")
	private	Date dateAdded;	
	@Column(name = "added_by", length = 20)
	private	String addedBy;	
	@Column(name = "date_modified")
	private	Date dateModified;	
	@Column(name = "modified_by", length = 20)
	private	String modifiedBy;	
			
	
}
