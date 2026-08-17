package com.rays.common;

import java.util.List;

public interface BaseDaoInt<T extends BaseDto> {

	public long add(T dto, UserContext userContext);

	public void update(T dto, UserContext userContext);

	public void delete(T dto, UserContext userContext);

	public T findByPk(long pk, UserContext userContext);

	public T findByUniqueKey(String attribute, Object val, UserContext userContext);

	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	public List search(T dto, UserContext userContext);
}