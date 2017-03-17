package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class SubscriptionFeatureMapping {
	private Long id;
	private String subscriptionCode;
	private String featureCode;
	private Date dateAdded;

}
