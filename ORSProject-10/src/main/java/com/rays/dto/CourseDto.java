package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDto;

@Entity
@Table(name = "st_course")
public class CourseDto extends BaseDto {

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "duration", length = 50)
	private String duration;

	@Column(name = "description", length = 255)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getUniqueKey() {
		return "name";
	}

	@Override
	public String getUniqueValue() {
		return name;
	}

	@Override
	public String getLabel() {
		return "Course Name";
	}
	
	@Override
	public String getTableName() {
		return "Course";
	}

	@Override
	public String getValue() {
		return name;
	}
}