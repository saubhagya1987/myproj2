package com.golenchi.web.feature.enums;

public enum FeatureType{

	EMPLOYEE("EMPLOYEE"),  ACCOUNT("ACCOUNT");

	private String desc;

	private FeatureType(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
