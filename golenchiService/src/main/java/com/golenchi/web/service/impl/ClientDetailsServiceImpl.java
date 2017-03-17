package com.golenchi.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.golenchi.web.dao.ClientOauthDetailsDao;
import com.golenchi.web.orgs.ClientOauthDetails;

@Service(value = "customClientDetailServiceImpl")
public class ClientDetailsServiceImpl implements ClientDetailsService {
	
	@Autowired
	private ClientOauthDetailsDao clientOauthDetailsDao;

	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		ClientOauthDetails clientOauthDetails = clientOauthDetailsDao.find(clientId);
		
		if(clientOauthDetails == null){
			throw new ClientRegistrationException("Client Not Found");
		}
		
		BaseClientDetails clientDetails = new BaseClientDetails(clientOauthDetails.getClientId(),
				clientOauthDetails.getResourceIds(), clientOauthDetails.getScope(),
				clientOauthDetails.getAuthorizedGrantTypes(),
				clientOauthDetails.getAuthorities());
		clientDetails.setClientSecret(clientOauthDetails.getClientSecret());
		clientDetails.setAccessTokenValiditySeconds(clientOauthDetails.getAccessTokenValidity());
		clientDetails.setRefreshTokenValiditySeconds(clientOauthDetails.getRefreshTokenValidity());
		return clientDetails;
	}
}
