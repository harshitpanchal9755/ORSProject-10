package com.rays.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.UserDaoInt;
import com.rays.dto.UserDto;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDto, UserDaoInt> implements UserServiceInt {

	@Transactional(readOnly = true)
	public UserDto findByLogin(String name, UserContext userContext) {
		// TODO Auto-generated method stub
		return baseDao.findByUniqueKey(name, name, userContext);
	}
}

 
