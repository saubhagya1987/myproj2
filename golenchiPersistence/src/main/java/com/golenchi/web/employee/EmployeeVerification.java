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

//@Entity(name = "EMPLOYEE_VERIFICATION")
public @Data class EmployeeVerification {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_verification_id")
	private Long employeeVerificationId;//Keeps track of employee's skill set"	Column Name	Type	Description
	@Column(name = "document_name", length = 50)
	private String documentName; 
	@Column(name = "description", length = 50)
	private String description;	
	@Column(name = "identification_number", length = 50)
	private String identificationNumber;
	@Column(name = "expiration_date")
	private Date expirationDate;	
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;	//foreign Key from employee table
	@Column(name = "date_added")
	private Date dateAdded;	
	@Column(name = "added_by", length = 20)
	private String sddedBy;	
	@Column(name = "date_modified")
	private Date dateModified;	
	@Column(name = "modified_by", length = 20)
	private String modifiedBy;	
			
	
			
	
	
			
	
}
