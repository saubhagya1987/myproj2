package com.golenchi.web.enums;

public enum Feature {
	FEATURE_NAME("featureCode", "featureName", "ROLE_USER"),
	ADD_GROUP("GR01", "addGroupName", "ROLE_ADD_GROUP");
	
	private String featureCode;
	private String featureName;
	private String role;

	private Feature(String featureCode, String featureName, String role ){
		this.featureCode = featureCode;
		this.featureName = featureName;
		this.role = role;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public String getFeatureName() {
		return featureName;
	}

	public String getRole() {
		return role;
	}
	
	public static Feature getFeatureByCode(String featureCode){
		Feature feature = null;
		for(Feature val : Feature.values()){
			if(val.featureCode.equals(featureCode)){
				feature = val;
				break;
			}
		}
		return feature;
	}
	
	public static Feature getFeatureByName(String featureName){
		Feature feature = null;
		for(Feature val : Feature.values()){
			if(val.featureName.equals(featureName)){
				feature = val;
				break;
			}
		}
		return feature;
	}
}
