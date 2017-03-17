package com.golenchi.web.feature.enums;

public enum UserAdministration implements FeatureCode  {

	CREATE_ROLE("UA01", "ROLE_CREATE_ROLE"),
	EDIT_ROLE("UA02",  "ROLE_EDIT_ROLET"),
	VIEW_ROLE("UA03","ROLE_VIEW_ROLE"),
	DELETE_ROLE("UA04", "ROLE_DELETE_ROLE"),
	LOCK_ACCOUNT("UA05", "ROLE_LOCK_ACCOUNT"),
	UNLOCK_ACCOUNT("UA06", "ROLE_UNLOCK_ACCOUNT");

	private String featureCode;
	private String role;
	
	private UserAdministration(String featureCode,String role) {
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
