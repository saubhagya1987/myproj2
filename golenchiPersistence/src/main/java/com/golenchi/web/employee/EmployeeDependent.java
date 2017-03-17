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

//@Entity(name = "EMPLOYEE_DEPENDENT")
public @Data class EmployeeDependent {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_dependent_id")
	private Integer employeeDependentId;
	@Column(name = "name", length = 50)
	private String name;	
	@Column(name = "relationship", length = 50)
	private String relationship;	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;	
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Company company;	//foreign Key from employee table
	@JoinColumn(name = "emp_code", referencedColumnName = "emp_code")
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;	//foreign Key from employee table
	
}
