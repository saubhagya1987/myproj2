package com.golenchi.web.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import com.golenchi.web.enums.BloodGroup;
import com.golenchi.web.enums.Gender;
import com.golenchi.web.enums.MaritalStatus;
import com.golenchi.web.enums.RoleType;
import com.golenchi.web.enums.Status;
import com.golenchi.web.orgs.Department;
import com.golenchi.web.orgs.Designation;
import com.golenchi.web.roles.Role;

import lombok.Data;

//@Entity(name = "EMPLOYEE")
public @Data class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;		
	//@Column(name = "company_id	varchar (20)	composite key
	//@Column(name = "emp_code	varchar (20)	composite key"	
	@Column(name = "first_name", length = 20)
	private String firstName;	
	@Column(name = "middle_name", length = 20)
	private String middleName;	
	@Column(name = "last_name", length = 20)
	private String lastName;	
	@Column(name = "image_url", length = 255)
	private String imageUrl;	
	@Column(name = "official_email_id", length = 50)
	private String officialEmailId;	
	@Column(name = "department_code", length = 20)
	private Department department;//	varchar (20)	foreign Key (mapping of department to employee)
	@Column(name = "location_code", length = 20)
	private String locationCode;	
	@Column(name = "reporting_manager_id")
	private String reportingManagerId;	
	@Column(name = "title", length = 50)
	private String title;	
	@Column(name = "source_of_hire_id")
	private String sourceOfHireId; // 	int	foreign Key
	@Column(name = "date_of_joining")
	private Date dateOfJoining;	
	@Column(name = "status")
	private Status status;//ENUM	ACTIVE/RESIGNED/HOLD
	@Column(name = "type_id")
	private RoleType roleType;//type_id	foreign Key
	@Column(name = "designation_id")
	private Designation designation;//int (FK)	foreign key (mapping of designation to employee)
	@Column(name = "work_phone", length = 20)
	private String workPhone;	
	@Column(name = "extension", length = 10)
	private String Extension;	
	@Column(name = "role_id")
	private Role role;//int	foreign Key
	@Column(name = "mobile_phone", length = 10)
	private String mobilePhone;	
	@Column(name = "other_email", length = 50)
	private String otherEmail;	
	@Column(name = "birth_date")
	private Date birthDate;	
	@Column(name = "marital_status")
	private MaritalStatus maritalStatus;	
	@Column(name = "job_description")
	private String jobDescription;	
	@Column(name = "about_me")
	private String aboutMe;	
	@Column(name = "skill_id")
//	private EmployeeSkillSet employeeSkillSet;//	int	foreign key
//	@Column(name = "date_of_exit")
	private Date dateOfExit;	
	@Column(name = "gender")
	private Gender gender;	
	@Column(name = "emergency_contact_name", length = 50)
	private String emergencyContactName;	
	@Column(name = "emergency_contact_number", length = 12)
	private String emergencyContactNumber;	
	@Column(name = "date_added")
	private Date dateAdded;	
	@Column(name = "added_by", length = 20)
	private String addedBy;	
	@Column(name = "modify_date")
	private Date modifyDate;	
	@Column(name = "modified_by", length = 20)
	private String modifiedBy;	
//	@Column(name = "blood_group")
//	private BloodGroup bloodGroup;	
			
	

}
