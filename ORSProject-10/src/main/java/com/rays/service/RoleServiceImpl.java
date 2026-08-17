package com.rays.service;

import com.rays.common.BaseDaoImpl;
import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.RoleDaoInt;
import com.rays.dto.RoleDto;

public class RoleServiceImpl extends BaseServiceImpl<RoleDto, RoleDaoInt> implements RoleServiceInt{
	
	public RoleDto findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("name", name, userContext );
		
	}

}
