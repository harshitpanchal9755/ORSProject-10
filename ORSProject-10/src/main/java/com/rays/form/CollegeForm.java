package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDto;
import com.rays.common.BaseForm;
import com.rays.dto.CollegeDto;

public class CollegeForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Address is required")
	private String address;

	@NotEmpty(message = "State is required")
	private String state;

	@NotEmpty(message = "City is required")
	private String city;

	@NotNull(message = "Phone No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public BaseDto getDto() {

		CollegeDto dto = initDto(new CollegeDto());
		dto.setName(name);
		dto.setAddress(address);
		dto.setState(state);
		dto.setCity(city);
		dto.setPhoneNo(phoneNo);

		return dto;
	}
}
