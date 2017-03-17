package com.golenchi.web.orgs;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.golenchi.web.enums.Level;

@Entity(name = "DESIGNATION")
public class Designation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "designation_id")
	private Long designationId;
	@Column(name = "name", length = 20, unique = true)
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "level")
	private Level level;
	@JoinColumn(name = "company_code", referencedColumnName = "company_code")
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	
	

}
