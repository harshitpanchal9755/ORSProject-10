package com.rays.common;

import com.rays.dto.UserDto;

public class UserContext {

	private Long userId = 0L;
	private String login = "root";
	private String name = null;
	private Long roleId = 0L;
	private String roleName = "root";

	private UserDto userDTO = null;

	public UserContext() {

	}

	public UserContext(UserDto dto) {
		this.userDTO = dto;
		this.userId = dto.getId();
		this.login = dto.getLoginId();
		this.name = dto.getName();
		this.roleId = dto.getRoleId();
		this.roleName = dto.getRoleName();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public UserDto getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDto userDTO) {
		this.userDTO = userDTO;
	}

}