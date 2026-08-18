package com.rays.service;
import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.UserDto;

public interface UserServiceInt extends BaseServiceInt<UserDto> {
	
	public UserDto findByLogin(String name, UserContext userContext);

}
