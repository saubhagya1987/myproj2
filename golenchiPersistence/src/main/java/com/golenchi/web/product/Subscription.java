package com.golenchi.web.product;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.golenchi.web.common.BaseDomain;
import com.golenchi.web.enums.SubscriptionType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "SUBSCRIPTION")
@EqualsAndHashCode(callSuper = false)
public @Data class Subscription extends BaseDomain {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_id")
	private long subscriptionId;
	@Column(name = "code", length = 20)
	private String code;
	@Column(name = "type")
	private SubscriptionType type;
	@Column(name = "description")
	private String description;

}
