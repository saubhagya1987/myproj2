package com.golenchi.web.user;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.golenchi.web.common.BaseDomain;
import com.golenchi.web.enums.Status;
import com.golenchi.web.orgs.Company;

@Entity(name = "USER_VERIFICATION")
@EqualsAndHashCode(callSuper=false)
public @Data class UserVerification extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "verification_id")
	private Integer	verificationId;
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Company company;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	@Column(name = "verification_code")
	private String verificationCode;
	@Column(name = "email_address", length=50)
	private String emailAddress;	 
	@Column(name = "mobile_no", length = 10)
	private String mobileNo;	 
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status")
	private Status status;	 
	
}
