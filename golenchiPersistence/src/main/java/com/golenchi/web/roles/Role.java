/**
 * 
 */
package com.golenchi.web.roles;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.golenchi.web.orgs.Company;

import lombok.Data;

@Entity
@Table(name = "ROLE")
public @Data class  Role implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private Long roleId;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	
	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "date_created")
	private Date dateCreated;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@Column(name = "date_modified")
	private Date dateModified;
	
	@Column(name = "modified_by")
	private Long modifiedBy;

	
	/*@ElementCollection(targetClass= Feature.class)
	@JoinTable(name = "ROLE_FEATURES", joinColumns = @JoinColumn(name = "role_id"))
	@Column(name = "feature", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<Feature> features;*/
	
	@ElementCollection(targetClass= String.class)
	@JoinTable(name = "ROLE_FEATURES", joinColumns = @JoinColumn(name = "role_id"))
	@Column(name = "feature", nullable = false)
	private Set<String> features;

}
