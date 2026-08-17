package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDto;

@Entity
@Table(name = "st_role")
public class RoleDto extends BaseDto {

	@Column(name = "name", length = 50)
	private String name = null;
	@Column(name = "description", length = 50)
	private String description = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "name";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Role Name";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Role";
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

}
