package com.golenchi.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.golenchi.web.dao.GenericDao;
import com.golenchi.web.dao.RoleDao;
import com.golenchi.web.roles.Role;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements GenericDao<Role> , RoleDao{

}