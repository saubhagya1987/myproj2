package com.golenchi.web.mappings;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "SUBSCRIPTION_FEATURE")
public @Data class SubscriptionFeature {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_feature_id")
	private Long subscriptionFeatureId;
	@Column(name = "subscription_id")
	private String subscriptionId;
	@Column(name = "feature_id")
	private String featureId;
	@Column(name = "date_added")
	private Date dateAdded;

}
