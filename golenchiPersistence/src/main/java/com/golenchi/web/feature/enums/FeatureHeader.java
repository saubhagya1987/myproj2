package com.golenchi.web.feature.enums;

public enum FeatureHeader {

	PROJECT("PROJECT"), ATTENDANCE("ATTENDANCE"), SETTINGS("SETTINGS");

	private String desc;

	private FeatureHeader(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
