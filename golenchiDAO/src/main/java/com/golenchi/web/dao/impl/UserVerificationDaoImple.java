package com.golenchi.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.golenchi.web.dao.GenericDao;
import com.golenchi.web.dao.UserVerificationDao;
import com.golenchi.web.user.UserVerification;

@Repository
public class UserVerificationDaoImple  extends GenericDaoImpl<UserVerification> implements GenericDao<UserVerification>, UserVerificationDao {

}
