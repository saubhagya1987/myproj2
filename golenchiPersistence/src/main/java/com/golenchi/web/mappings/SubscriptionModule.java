package com.golenchi.web.mappings;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.golenchi.web.enums.ModuleType;

import lombok.Data;

@Entity(name = "SUBSCRIPTION_MODULE")
public @Data class SubscriptionModule {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_module_id")
	private Long subscriptionModuleId;
	@Column(name = "subscription_id")
	private String subscriptionId;
	@Column(name = "module_id")
	private String moduleId;
	@Column(name = "module_type")
	private ModuleType moduleType;
	@Column(name = "date_added")
	private Date dateAdded;

}
