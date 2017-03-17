package com.golenchi.web.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao<BaseDomain> {

	BaseDomain save(BaseDomain baseDomain);

	void delete(BaseDomain id);

	BaseDomain find(Object id);

	BaseDomain merge(BaseDomain baseDomain);

	BaseDomain findSingleResultByNameQuery(String queryName, Map<String, Object> fieldValue);

	List<BaseDomain> findResultsByNameQuery(String queryName, Map<String, Object> fieldValue);

	/*
	List<T> getPageResultByCriteria(
			Map<Junction, List<CriteriaObject>> criteriaObjects,
			Integer startIndex, Integer maxResult);

	*//**
	 * @param criteriaObjects
	 * @return
	 *//*
	List<T> getResultByCriteria(
			Map<Junction, List<CriteriaObject>> criteriaObjects);
*/
	BaseDomain load(Object id);

	void flush();

	List<BaseDomain> findPageByNameQuery(String queryName, Map<String, Object> fieldValue, Integer startOffset, Integer maxResult);

	void detach(BaseDomain baseDomain);

}
