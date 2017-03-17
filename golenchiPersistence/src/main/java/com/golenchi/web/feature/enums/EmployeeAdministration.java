package com.golenchi.web.feature.enums;

public enum EmployeeAdministration implements FeatureCode  {

	CREATE_EMPLOYEE("EA01", "ROLE_CREATE_EMPLOYEE"),
	EDIT_EMPLOYEE("EA02",  "ROLE_EDIT_EMPLOYEE"),
	DELETE_EMPLOYEE("EA03","ROLE_DELETE_EMPLOYEE"),
	ACTIVATE_EMPLOYEE("EA04", "ROLE_ACTIVATE_EMPLOYEE"),
	DEACTIVATE_EMPLOYEE("EA05", "ROLE_DEACTIVATE_EMPLOYEE"),
	SKILL_READ("EA06", "ROLE_SKILL_READ"),
	SKILL_VIEW("EA07", "ROLE_SKILL_VIEW"),
	SKILL_WRITE("EA08", "ROLE_SKILL_WRITE"),
	VIEW_EMPLOYEE("EA09", "ROLE_VIEW_EMPLOYEE");

	private String featureCode;
	private String role;
	
	private EmployeeAdministration(String featureCode,String role) {
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
