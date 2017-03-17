/**
 * 
 */
package com.golenchi.web.dao.impl;

import org.springframework.stereotype.Service;

import com.golenchi.web.dao.FeaturesDao;
import com.golenchi.web.dao.GenericDao;
import com.golenchi.web.product.Features;

/**
 * @author rahul
 *
 */
@Service
public class FeaturesDaoImpl  extends GenericDaoImpl<Features> implements FeaturesDao,
GenericDao<Features>  {

}
