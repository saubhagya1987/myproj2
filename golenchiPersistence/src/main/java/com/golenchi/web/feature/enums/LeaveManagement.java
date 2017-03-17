package com.golenchi.web.feature.enums;

public enum LeaveManagement implements FeatureCode  {

	APPLY_LEAVE("LM01","ROLE_APPLY_LEAVE"),
	APPROVE_LEAVE("LM02","ROLE_APPROVE_LEAVE");

	private String featureCode;
	private String role;
	
	private LeaveManagement(String featureCode,String role) {
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
