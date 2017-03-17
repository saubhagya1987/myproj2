package com.golenchi.web.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.golenchi.web.common.BaseDomain;
import com.golenchi.web.enums.Status;
import com.golenchi.web.orgs.Company;
import com.golenchi.web.roles.Role;

@Entity
@Table(name = "USER")
@EqualsAndHashCode(callSuper=false)
@NamedQueries({@NamedQuery(name="User.findByUsername", query="SELECT user FROM User user WHERE user.username = :username")})
public @Data class User extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "username", length = 50, unique=true,nullable=false)
	private String username;
	@Column(name = "password", length = 200)
	private String password;
	@Column(name = "first_name", length = 50)
	private String firstName;
	@Column(name = "last_name", length = 50)
	private String lastName;
	@Column(name = "email_address", length = 50,unique=true, nullable=false)
	private String emailAddress;
	@JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable=false)
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status")
	private Status status;
	
	@OneToMany
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Role> roles;
	
	

}
