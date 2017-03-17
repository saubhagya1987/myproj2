/**
 * 
 */
package com.golenchi.web.dao.impl;

import org.springframework.stereotype.Service;

import com.golenchi.web.dao.CompanyDao;
import com.golenchi.web.dao.GenericDao;
import com.golenchi.web.orgs.Company;

/**
 * @author rahul
 *
 */
@Service
public class CompanyDaoImpl extends GenericDaoImpl<Company> implements CompanyDao,
		GenericDao<Company> {
	
}
