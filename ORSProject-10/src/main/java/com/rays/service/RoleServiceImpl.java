package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseDaoImpl;
import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.RoleDaoInt;
import com.rays.dto.RoleDto;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleDto, RoleDaoInt> implements RoleServiceInt{
	
	@Transactional(readOnly = true)
	public RoleDto findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("name", name, userContext );
		
	}

}
