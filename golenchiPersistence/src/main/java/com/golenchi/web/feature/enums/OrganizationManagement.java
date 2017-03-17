package com.golenchi.web.feature.enums;

public enum OrganizationManagement implements FeatureCode  {

	CREATE_DEPARTMENT("OM01", "ROLE_CREATE_DEPARTMENT"),
	VIEW_DEPARTMENT("OM02",  "ROLE_VIEW_DEPARTMENT"),
	EDIT_DEPARTMENT("OM03","ROLE_EDIT_DEPARTMENT"),
	DELETE_DEPARTMENT("OM04", "ROLE_DELETE_DEPARTMENT"),
	CREATE_DESIGNATION("OM05","ROLE_CREATE_DESIGNATION"),
	VIEW_DESIGNATION("OM06", "ROLE_VIEW_DESIGNATION"),
	EDIT_DESIGNATION("OM07", "ROLE_EDIT_DESIGNATION"),
	DELETE_DESIGNATION("OM08", "ROLE_DELETE_DESIGNATION");

	private String featureCode;
	private String role;
	
	private OrganizationManagement(String featureCode,String role) {
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
