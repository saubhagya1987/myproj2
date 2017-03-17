package com.golenchi.web.feature.enums;

public enum TimeManagement implements FeatureCode  {

	ALLOCATE_RESOURCE_TO_PROJECT("TM01", "ROLE_ALLOCATE_RESOURCE_TO_PROJECT"),
	REQUEST_FOR_ALLOCATION("TM02",  "ROLE_REQUEST_FOR_ALLOCATION"),
	APPROVE_REQUEST_OF_ALLOCATION("TM03","ROLE_APPROVE_REQUEST_OF_ALLOCATION"),
	NON_VACATION_TIME("TM04", "ROLE_NON_VACATION_TIME"),
	RESOURCE_TIME("TM05","ROLE_RESOURCE_TIME"),
	TIME_SPENT_ON_PROJECT("TM06", "ROLE_TIME_SPENT_ON_PROJECT"),
	APPROVE_CONTRACTOR_TIME("TM07", "ROLE_APPROVE_CONTRACTOR_TIME"),
	DOWNLOAD_TIME_SHEET("TM08", "ROLE_DOWNLOAD_TIME_SHEET");

	private String featureCode;
	private String role;
	
	private TimeManagement(String featureCode,String role) {
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
