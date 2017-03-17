package com.golenchi.web.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.golenchi.web.dao.GenericDao;

@Repository
public abstract class GenericDaoImpl<BaseDomain> implements GenericDao<BaseDomain> {

	@PersistenceContext(unitName = "golenchi_DS", type = PersistenceContextType.TRANSACTION)
	protected EntityManager em;
	
	
	
	
	private Class<BaseDomain> entityClass;
	private Logger LOGGER = LoggerFactory.getLogger(GenericDaoImpl.class);

	public GenericDaoImpl(Class<BaseDomain> entityClass) {
		this.entityClass = entityClass;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entityClass = (Class) pt.getActualTypeArguments()[0];		
	}

	@Override
	public BaseDomain save(final BaseDomain baseDomain) {
		this.em.persist(baseDomain);
		return baseDomain;
	}
	@Override
	public void flush() {
		this.em.flush();
	}

	@Override
	public void delete(BaseDomain id) {
		this.em.remove(merge(id));
	}

	@Override
	public BaseDomain find(final Object id) {
		return (BaseDomain) this.em.find(entityClass, id);
	}

	@Override
	public BaseDomain load(final Object id) {
		return (BaseDomain) this.em.getReference(entityClass, id);
	}

	@Override
	public BaseDomain merge(final BaseDomain baseDomain) {
		return this.em.merge(baseDomain);
	}
	
	@Override
	public void detach(final BaseDomain baseDomain) {
	    org.hibernate.Session session = (Session) em.getDelegate();
	    session.evict(baseDomain);
	}

	@Override
	public List<BaseDomain> findResultsByNameQuery(String queryName, Map<String, Object> fieldValue) {

		try {
			TypedQuery<BaseDomain> query = (TypedQuery<BaseDomain>) em.createNamedQuery(queryName, entityClass);
			Set<Entry<String, Object>> entrySet = fieldValue.entrySet();

			for (Entry<String, Object> entry : entrySet)
				query.setParameter(entry.getKey(), entry.getValue());

			return query.getResultList();
		} catch(NoResultException ex){
			ex.printStackTrace();
			LOGGER.debug("EXCEPTION ENTITY CLASS "+entityClass + " "+ExceptionUtils.getStackTrace(ex));
			return Collections.emptyList();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex ;//new SystemException(ex);
//			return null;
		}
	}

	@Override
	public BaseDomain findSingleResultByNameQuery(String queryName, Map<String, Object> fieldValue) {
		try {
			TypedQuery<BaseDomain> query = (TypedQuery<BaseDomain>) em.createNamedQuery(queryName, entityClass);
			Set<Entry<String, Object>> entrySet = fieldValue.entrySet();

			for (Entry<String, Object> entry : entrySet)
				query.setParameter(entry.getKey(), entry.getValue());

			return query.getSingleResult();
		} catch(NoResultException ex){
			LOGGER.debug("EXCEPTION ENTITY CLASS "+entityClass + " "+ExceptionUtils.getStackTrace(ex));
			return null;
		}
		catch (Exception ex) {
			throw  ex ;//new SystemException(ex);
		}
	}
/*
	@Override
	public List<T> getPageResultByCriteria(
			Map<Junction, List<CriteriaObject>> criteriaObjects,
			Integer startIndex, Integer maxResult) {
		
		 * 
		 * CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); final CriteriaQuery<T> criteriaQuery =
		 * criteriaBuilder .createQuery(entityClass);
		 * 
		 * Root<T> root = criteriaQuery.from(entityClass); criteriaQuery.select(root); Predicate resultPredicate = null;
		 * 
		 * Set<Entry<Junction, List<CriteriaObject>>> entrySet = criteriaObjects .entrySet(); for (Entry<Junction,
		 * List<CriteriaObject>> entry : entrySet) { if (Junction.AND.equals(entry.getKey())) resultPredicate =
		 * getConjunctionPredicate(entry.getValue(), root, criteriaBuilder, resultPredicate); else { resultPredicate =
		 * getDisjunctionPredicate(entry.getValue(), root, criteriaBuilder, resultPredicate); }
		 * 
		 * }
		 * 
		 * if(resultPredicate != null) criteriaQuery.where(resultPredicate);
		 

		TypedQuery<T> query = em
				.createQuery(getCriteriaQueryByCriteria(criteriaObjects));
		if (startIndex != null && maxResult != null) {
			query.setFirstResult(startIndex);
			query.setMaxResults(maxResult);
		}
		return query.getResultList();
	}

	@Override
	public List<T> getResultByCriteria(
			Map<Junction, List<CriteriaObject>> criteriaObjects) {

		
		 * CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); final CriteriaQuery<T> criteriaQuery =
		 * criteriaBuilder .createQuery(entityClass);
		 * 
		 * Root<T> root = criteriaQuery.from(entityClass); criteriaQuery.select(root); Predicate resultPredicate = null;
		 * 
		 * Set<Entry<Junction, List<CriteriaObject>>> entrySet = criteriaObjects .entrySet(); for (Entry<Junction,
		 * List<CriteriaObject>> entry : entrySet) { if (Junction.AND.equals(entry.getKey())) resultPredicate =
		 * getConjunctionPredicate(entry.getValue(), root, criteriaBuilder, resultPredicate); else { resultPredicate =
		 * getDisjunctionPredicate(entry.getValue(), root, criteriaBuilder, resultPredicate); }
		 * 
		 * }
		 * 
		 * if(resultPredicate != null) criteriaQuery.where(resultPredicate);
		 

		TypedQuery<T> query = em
				.createQuery(getCriteriaQueryByCriteria(criteriaObjects));

		return query.getResultList();
	}
	*/
	@Override
	public List<BaseDomain> findPageByNameQuery(String queryName, Map<String, Object> fieldValue, Integer startOffset, Integer maxResult) {

		try {
			TypedQuery<BaseDomain> query = (TypedQuery<BaseDomain>) em.createNamedQuery(queryName, entityClass);
			Set<Entry<String, Object>> entrySet = fieldValue.entrySet();

			for (Entry<String, Object> entry : entrySet)
				query.setParameter(entry.getKey(), entry.getValue());
			
			query.setFirstResult(startOffset);
			query.setMaxResults(maxResult);
				
			return query.getResultList();
		} catch(NoResultException ex){
			return Collections.emptyList();
		}catch (Exception ex) {
			throw ex ;//new SystemException(ex);
		}
	}

	/********************************************** private Method ********************************/
	/*private CriteriaQuery<T> getCriteriaQueryByCriteria(
			Map<Junction, List<CriteriaObject>> criteriaObjects) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder
				.createQuery(entityClass);

		Root<T> root = criteriaQuery.from(entityClass);
		criteriaQuery.select(root);
		Predicate resultPredicate = null;

		Set<Entry<Junction, List<CriteriaObject>>> entrySet = criteriaObjects
				.entrySet();
		for (Entry<Junction, List<CriteriaObject>> entry : entrySet) {
			if (Junction.AND.equals(entry.getKey()))
				resultPredicate = getConjunctionPredicate(entry.getValue(),
						root, criteriaBuilder, resultPredicate);
			else {
				resultPredicate = getDisjunctionPredicate(entry.getValue(),
						root, criteriaBuilder, resultPredicate);
			}

		}

		if (resultPredicate != null)
			criteriaQuery.where(resultPredicate);

		return criteriaQuery;
	}

	private Predicate getDisjunctionPredicate(List<CriteriaObject> value,
			Root<T> root, CriteriaBuilder criteriaBuilder,
			Predicate resultPredicate) {
		Predicate predicate = null;

		for (CriteriaObject criteriaObject : value) {
			predicate = getPredicate(criteriaObject, criteriaBuilder, root);

			if (resultPredicate != null) {
				resultPredicate = criteriaBuilder
						.or(resultPredicate, predicate);
			} else {
				resultPredicate = predicate;
			}

		}
		return resultPredicate;
	}

	private Predicate getConjunctionPredicate(List<CriteriaObject> value,
			Root<T> root, CriteriaBuilder criteriaBuilder,
			Predicate resultPredicate) {

		Predicate predicate = null;

		for (CriteriaObject criteriaObject : value) {
			predicate = getPredicate(criteriaObject, criteriaBuilder, root);

			if (resultPredicate != null) {
				resultPredicate = criteriaBuilder.and(resultPredicate,
						predicate);
			} else {
				resultPredicate = predicate;
			}

		}
		return resultPredicate;

	}

	private Predicate getPredicate(CriteriaObject criteriaObject,
			CriteriaBuilder criteriaBuilder, Root<T> root) {
		Predicate predicate = null;
		switch (criteriaObject.getOperator()) {
			case GREATER_THAN :
				if (criteriaObject.getValue() instanceof Number)
					predicate = criteriaBuilder.gt(root
							.<Number> get(criteriaObject.getFieldName()),
							(Number) criteriaObject.getValue());
				else if (criteriaObject.getValue() instanceof Date)
					predicate = criteriaBuilder.greaterThan(root
							.<Date> get(criteriaObject.getFieldName()),
							(Date) criteriaObject.getValue());
				else if (criteriaObject.getValue() instanceof String)
					predicate = criteriaBuilder.greaterThan(root
							.<String> get(criteriaObject.getFieldName()),
							(String) criteriaObject.getValue());
				break;

			case GREATER_EQUAL :
				if (criteriaObject.getValue() instanceof Number)
					predicate = criteriaBuilder.ge(root
							.<Number> get(criteriaObject.getFieldName()),
							(Number) criteriaObject.getValue());
				else if (criteriaObject.getValue() instanceof Date)
					predicate = criteriaBuilder.greaterThanOrEqualTo(root
							.<Date> get(criteriaObject.getFieldName()),
							(Date) criteriaObject.getValue());
				else if (criteriaObject.getValue() instanceof String)
					predicate = criteriaBuilder.greaterThanOrEqualTo(root
							.<String> get(criteriaObject.getFieldName()),
							(String) criteriaObject.getValue());
				break;

			case EQUALS :
				predicate = criteriaBuilder.equal(root.get(criteriaObject
						.getFieldName()), criteriaObject.getValue());
				break;
			case NOT_EQUALS :
				predicate = criteriaBuilder.notEqual(root.get(criteriaObject
						.getFieldName()), criteriaObject.getValue());
				break;
			case LESS_THAN :
				if (criteriaObject.getValue() instanceof Number)
					predicate = criteriaBuilder.lt(root
							.<Number> get(criteriaObject.getFieldName()),
							(Number) criteriaObject.getValue());
				else if (criteriaObject.getValue() instanceof Date)
					predicate = criteriaBuilder.lessThan(root
							.<Date> get(criteriaObject.getFieldName()),
							(Date) criteriaObject.getValue());
				else if (criteriaObject.getValue() instanceof String)
					predicate = criteriaBuilder.lessThan(root
							.<String> get(criteriaObject.getFieldName()),
							(String) criteriaObject.getValue());

				break;
			case LESSOR_THAN_EQUAL :
				if (criteriaObject.getValue() instanceof Number)
					predicate = criteriaBuilder.le(root
							.<Number> get(criteriaObject.getFieldName()),
							(Number) criteriaObject.getValue());
				else if (criteriaObject.getValue() instanceof Date)
					predicate = criteriaBuilder.lessThanOrEqualTo(root
							.<Date> get(criteriaObject.getFieldName()),
							(Date) criteriaObject.getValue());
				else if (criteriaObject.getValue() instanceof String)
					predicate = criteriaBuilder.lessThanOrEqualTo(root
							.<String> get(criteriaObject.getFieldName()),
							(String) criteriaObject.getValue());

				break;
			default :
				System.out.println("Error");
				break;
		}
		return predicate;

	}*/
}
