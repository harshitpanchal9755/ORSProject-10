package com.rays.common;

import java.util.List;

public interface BaseServiceInt<T extends BaseDto> {

	public long add(T dto, UserContext userContext);

	public void update(T dto, UserContext userContext);

	public long save(T dto, UserContext userContext);

	public T delete(long id, UserContext userContext);

	public T findById(long id, UserContext userContext);

	public T findByUniqueKey(String attribute, String val, UserContext userContext);

	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	public List search(T dto, UserContext userContext);

}