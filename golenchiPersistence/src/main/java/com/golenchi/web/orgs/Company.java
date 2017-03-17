package com.golenchi.web.orgs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.golenchi.web.common.BaseDomain;

@Entity
@Table(name = "COMPANY")
@EqualsAndHashCode(callSuper=false)
@NamedQueries({@NamedQuery(name="Company.findByEmail", query="SELECT comp FROM Company comp WHERE comp.emailAddress = :emailAddress")})
public @Data class Company extends BaseDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id", nullable = false)
	private Integer companyId;
	@Column(name = "company_code", nullable = false, length = 20)
	private String companyCode;
	@Column(name = "company_url", length = 50)
	private String companyUrl;
	@Column(name = "company_name", length = 100)
	private String companyName;
	@Column(name = "company_address", length = 200)
	private String companyAddress;
	@Column(name = "city", length = 50)
	private String city;
	@Column(name = "state", length = 50)
	private String state;
	@Column(name = "zip")
	private Integer zip;
	@Column(name = "country", length = 50)
	private String country;
	@Column(name = "email_address", length = 50)
	private String emailAddress;
	@Column(name = "contact_number1")
	private String contactNumber1;
	@Column(name = "contact_number2")
	private String contactNumber2;
	@Column(name = "fax")
	private String fax;
	@Column(name = "subscription_id")
	private String subscriptionCode;
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (companyId ^ (companyId >>> 32));
		result = prime * result
				+ ((companyUrl == null) ? 0 : companyUrl.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Company)) {
			return false;
		}
		Company other = (Company) obj;
		if (companyId != other.companyId) {
			return false;
		}else if (companyCode == null) {
			if (other.companyCode != null) {
				return false;
			}
		} else if (!companyCode.equals(other.companyCode)) {
			return false;
		}
		return true;
	}

}
