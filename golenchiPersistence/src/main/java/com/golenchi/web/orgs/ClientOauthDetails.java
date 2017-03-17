package com.golenchi.web.orgs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "CLIENT_OAUTH_DETAILS")
public @Data class ClientOauthDetails {
	@Id
	@Column(name="client_id", length=255)
	private String clientId ;

	@Column(name="resource_ids", length=255)
	private String resourceIds ;
	
	@Column(name="client_secret", length=255)
	private String clientSecret ;

	@Column(name="scope", length=255)
	private String scope ;
	
	@Column(name="authorized_grant_types", length=255)
	private String authorizedGrantTypes ;
	
	@Column(name="authorities", length=255)
	private String authorities ;

	@Column(name="access_token_validity")
	private int accessTokenValidity ;

	@Column(name="refresh_token_validity")
	private int refreshTokenValidity ;

}
