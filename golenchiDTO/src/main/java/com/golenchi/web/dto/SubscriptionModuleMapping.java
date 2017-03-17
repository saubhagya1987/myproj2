package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class SubscriptionModuleMapping {
	private Long id;
	private String subscriptionCode;
	private String moduleCode;
	private ModuleType moduleType;
	private Date dateAdded;

}
