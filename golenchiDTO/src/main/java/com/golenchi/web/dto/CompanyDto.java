package com.golenchi.web.dto;

import java.io.Serializable;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public @Data class CompanyDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String companyUrl;
	private String companyName;
	private String companyAddress;
	private String city;
	private String state;
	private Integer zip;
	private String country;
	private String emailAddress;
	private String subscriptionCode;	
	private String contactNumber1;
	private String contactNumber2;
	private String fax;
	
}
