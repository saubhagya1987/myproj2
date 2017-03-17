package com.golenchi.web.feature.enums;

public enum CompanyAdministration implements FeatureCode  {

	ADD_COMPANY_DETAIL("CA01", "ROLE_ADD_COMPANY_DETAIL"),
	EDIT_COMPANY_DETAIL("CA02",  "ROLE_EDIT_COMPANY_DETAIL"),
	BILLING_DETAIL("CA03","ROLE_BILLING_DETAIL"),
	DO_BILLING("UA04", "ROLE_DO_BILLING"),
	BILLING_HISTORY("CA05", "ROLE_BILLING_HISTORY"),
	CANCEL_SUBSCRIPTION("CA06", "ROLE_CANCEL_SUBSCRIPTION"),
	VIEW_SUBSCRIPTION("CA07", "ROLE_VIEW_SUBSCRIPTION")	;

	private String featureCode;
	private String role;
	
	private CompanyAdministration(String featureCode,String role) {
		// TODO Auto-generated constructor stub
		this.featureCode=featureCode;
		this.role=role;
	}
	@Override
	public String getFeatureCode() {
		// TODO Auto-generated method stub
		return featureCode;
	}
	@Override
	public String getFeatureName() {
		// TODO Auto-generated method stub
		return this.name();
	}
	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return role;
	}
}
