package com.golenchi.web.feature.enums;

public enum TimeAdministration implements FeatureCode {

	CREATE_PROJECT("TA01", "ROLE_CREATE_PROJECT");

	private String featureCode;
	private String role;
	
	private TimeAdministration(String featureCode,String role) {
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
