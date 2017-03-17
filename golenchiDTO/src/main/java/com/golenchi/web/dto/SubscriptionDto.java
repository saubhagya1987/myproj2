package com.golenchi.web.dto;

import java.util.Date;

import lombok.Data;

public @Data class SubscriptionDto {
	private long id;
	private String code;
	private SubscriptionType type;
	private String description;
	private Date dateModified;

}
