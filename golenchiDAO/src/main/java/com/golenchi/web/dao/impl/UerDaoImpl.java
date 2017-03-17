package com.golenchi.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.golenchi.web.dao.GenericDao;
import com.golenchi.web.dao.UserDao;
import com.golenchi.web.user.User;
@Repository
public class UerDaoImpl extends GenericDaoImpl<User> implements GenericDao<User>, UserDao {
	
}