package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDto;

@Entity
@Table(name = "st_subject")
public class SubjectDto extends BaseDto{
	
	@Column(name = "course_id", length = 50)
	private long courseId;

	@Column(name = "course_name", length = 50)
	private String courseName;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "description", length = 255)
	private String description;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

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
		return "name";
	}

	@Override
	public String getUniqueValue() {
		return name;
	}

	@Override
	public String getLabel() {
		return "Subject Name";
	}
	
	@Override
	public String getTableName() {
		return "Subject";
	}

	@Override
	public String getValue() {
		return name;
	}

}
