package com.golenchi.web.feature.enums;

public enum LeaveAdministration implements FeatureCode {

	CREATE_LEAVE_TYPE("LA01","ROLE_CREATE_LEAVE_TYPE"),
	EDIT_LEAVE_TYPE("LA02", "ROLE_EDIT_LEAVE_TYPE"),
	LIST_LEAVE_TYPE("LA03","ROLE_LIST_LEAVE_TYPE"),
	LEAVE_ENTITLEMENT("LA04", "ROLE_LEAVE_ENTITLEMENT");
	
	private String featureCode;
	private String role;
	
	private LeaveAdministration(String featureCode,String role) {
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
