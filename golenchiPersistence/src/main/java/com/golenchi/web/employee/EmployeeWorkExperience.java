package com.golenchi.web.employee;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.golenchi.web.orgs.Company;

import lombok.Data;

//@Entity(name = "EMPLOYEE_WORK_EXPERIENCE")
public @Data class EmployeeWorkExperience {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_work_experience_id")
	private Long employeeWorkExperienceId;
	@Column(name = "previous_company_name", length = 100)
	private String previousCompanyName;	
	@Column(name = "job_title", length = 200)
	private String jobTitle;	
	@Column(name = "from_date")
	private Date fromDate;	
	@Column(name = "to_date	date")
	private Date toDate;	
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Company company;	//foreign Key from employee table
	@JoinColumn(name = "emp_code", referencedColumnName = "emp_code")
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;	//foreign Key from employee table
			
}
