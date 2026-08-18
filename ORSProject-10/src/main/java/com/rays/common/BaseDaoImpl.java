package com.rays.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class BaseDaoImpl<T extends BaseDto> implements BaseDaoInt<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public abstract Class<T> getDtoClass();

	protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

	protected void populate(T dto, UserContext userContext) {

	}

	@Override
	public long add(T dto, UserContext userContext) {

		dto.setCreatedBy(userContext.getLogin());
		dto.setCreatedDatetime((new Timestamp(new Date().getTime())));
		dto.setModifiedBy(userContext.getLogin());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.persist(dto);

		return dto.getId();
	}

	@Override
	public void update(T dto, UserContext userContext) {

		dto.setModifiedBy(userContext.getLogin());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.merge(dto);
	}

	@Override
	public void delete(T dto, UserContext userContext) {
		entityManager.remove(dto);
	}

	@Override
	public T findByPk(long pk, UserContext userContext) {
		T dto = entityManager.find(getDtoClass(), pk);
		return dto;
	}

	@Override
	public T findByUniqueKey(String attribute, Object val, UserContext userContext) {
		Class<T> dtoClass = getDtoClass();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(dtoClass);

		Root<T> qRoot = cq.from(dtoClass);

		Predicate condition = builder.equal(qRoot.get(attribute), val);

		cq.where(condition);

		TypedQuery<T> query = entityManager.createQuery(cq);

		List<T> list = query.getResultList();

		T dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}
		return dto;
	}

	protected TypedQuery<T> createdCriteria(T dto, UserContext userContext) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(getDtoClass());

		Root<T> qRoot = cq.from(getDtoClass());

		cq.select(qRoot);

		List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);

		cq.where(whereClause.toArray(new Predicate[whereClause.size()]));

		TypedQuery<T> query = entityManager.createQuery(cq);

		return query;

	}

	@Override
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {

		TypedQuery<T> query = createdCriteria(dto, userContext);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List list = query.getResultList();
		return list;
	}

	@Override
	public List search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

	protected boolean isEmptyString(String val) {
		return val == null || val.trim().length() == 0;
	}

	protected boolean isZeroNumber(Double val) {
		return val == null || val == 0;
	}

	protected boolean isZeroNumber(Long val) {
		return val == null || val == 0;
	}

	protected boolean isZeroNumber(Integer val) {
		return val == null || val == 0;
	}

	protected boolean isNotNull(Object val) {
		return val != null;
	}

}