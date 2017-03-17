package com.golenchi.web.service.impl;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golenchi.web.dao.CompanyDao;
import com.golenchi.web.dao.FeaturesDao;
import com.golenchi.web.dao.RoleDao;
import com.golenchi.web.dto.RoleDto;
import com.golenchi.web.orgs.Company;
import com.golenchi.web.roles.Role;
import com.golenchi.web.service.RoleManagementService;

@Service
public class RoleManagementServiceImpl implements RoleManagementService {
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private FeaturesDao featureDao;

	@Autowired
	private RoleDao roleDao;

	@Override
	public void createRole(RoleDto dto) {
		Company company = companyDao.load(dto.getCompanyId());
		// GroupId id = new GroupId();

		Role role = new Role();
		role.setCompany(company);
		role.setName(dto.getName());

		role.setDescription(dto.getDescription());
		role.setCreatedBy(dto.getCreatedBy());
		role.setDateCreated(new Date());
		role.setDateModified(new Date());
		role.setModifiedBy(dto.getModifiedBy());
		Set<String> featureNames = dto.getFeatureNames();
		
		/*Set<Feature> features = new HashSet<>();
		featureNames.forEach(featureName -> {
			features.add(Feature.getFeatureByName(featureName));
		});*/

		//role.setFeatures(features);
		role.setFeatures(featureNames);
		roleDao.save(role);

	}

	@Override
	public void editRole(RoleDto dto) {

		Role role = roleDao.find(dto.getId());

		if (role == null) {
			throw new RuntimeException("role.not.found");
		}
		boolean isModified = false;
		if (dto.getName().trim().isEmpty()
				&& !role.getName().equals(dto.getName())) {
			role.setName(dto.getName());
			isModified = true;
		}

		if (dto.getDescription().trim().isEmpty()
				&& !role.getDescription().equals(dto.getDescription())) {
			role.setDescription(dto.getDescription());
			isModified = true;
		}

		if (!dto.getFeatureNames().isEmpty()) {
			
			/*role.getFeatures().clear();
			dto.getFeatureNames().forEach(name -> {
				role.getFeatures().add(Feature.getFeatureByName(name));

			});*/
			
			role.getFeatures().addAll(dto.getFeatureNames());
			
			isModified = true;
		}

		if (isModified) {

			role.setDateModified(new Date());
			role.setModifiedBy(dto.getModifiedBy());
		}

	}

}
