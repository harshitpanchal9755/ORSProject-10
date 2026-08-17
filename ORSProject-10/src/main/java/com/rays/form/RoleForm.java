package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDto;
import com.rays.common.BaseForm;
import com.rays.dto.RoleDto;

public class RoleForm extends BaseForm {

	public static final int ADMIN = 1;
	public static final int STUDENT = 2;
	public static final int FACULTY = 3;
	public static final int KIOSK = 4;

	@NotEmpty(message = "Description is Required")
	private String description;

	@NotEmpty(message = "Name is Required")
	private String name;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public BaseDto getDto() {
		RoleDto dto = (RoleDto) initDTO(new RoleDto());
		dto.setDescription(description);
		dto.setName(name);
		return dto;	
	}

}
