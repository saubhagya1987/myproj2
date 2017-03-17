package com.golenchi.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.golenchi.web.dao.AccountManagementDao;
import com.golenchi.web.dao.GenericDao;
import com.golenchi.web.orgs.Company;
//import com.golenchi.web.exceptions.SystemException;


@Repository
public class AccountManagementDaoImpl extends GenericDaoImpl<Company> implements GenericDao<Company>,AccountManagementDao {

	/*@PersistenceContext(unitName = "golenchi_DS", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Company addCompany(Company company) throws SystemException, BusinessException {
		
		System.out.println("Working into AccountManagementDaoImpl");
		company = this.entityManager.merge(company);
		return company;
	}*/

}
