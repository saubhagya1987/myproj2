package com.golenchi.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.golenchi.web.dao.ClientOauthDetailsDao;
import com.golenchi.web.dao.GenericDao;
import com.golenchi.web.orgs.ClientOauthDetails;
@Repository
public class ClientOauthDetailsDaoImpl extends GenericDaoImpl<ClientOauthDetails> implements GenericDao<ClientOauthDetails>, ClientOauthDetailsDao {
	
}