package com.golenchi.web.employee;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.golenchi.web.enums.EmployeeAddressType;
import com.golenchi.web.orgs.Company;

import lombok.Data;

//@Entity(name = "EMPLOYEE_ADDRESS")
public @Data class EmployeeAddress {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_address_id")
	private Long employeeAddressId;	
	@Column(name = "line_1", length = 255)
	private String lineOne;	
	@Column(name = "line_2", length = 255)
	private String linTwo;	
	@Column(name = "city", length = 100)
	private String city;	
	@Column(name = "state", length = 100)
	private String state;	
	@Column(name = "pincode", length = 100)
	private String pincode;	
	@Column(name = "type")
	private EmployeeAddressType employeeAddressType;
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Company company;	//foreign Key from employee table
	@JoinColumn(name = "emp_code", referencedColumnName = "emp_code")
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;	//foreign Key from employee table
}
