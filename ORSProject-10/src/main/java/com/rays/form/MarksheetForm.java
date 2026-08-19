package com.rays.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDto;
import com.rays.common.BaseForm;
import com.rays.dto.MarksheetDto;

public class MarksheetForm extends BaseForm{
	@NotEmpty(message = "Roll No is required")
	protected String rollNo = null;

	@NotNull(message = "Student Name is required")
	@Min(1)
	protected Long studentId;

	protected String name = null;

	@NotNull(message = "Physics is required")
	@Max(99)
	@Min(0)
	protected Integer physics;

	@NotNull(message = "Chemistry is required")
	@Max(99)
	@Min(0)
	protected Integer chemistry;

	@NotNull(message = "Maths is required")
	@Max(99)
	@Min(0)
	protected Integer maths;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	@Override
	public BaseDto getDto() {

		MarksheetDto dto = initDto(new MarksheetDto());
		dto.setRollNo(rollNo);
		dto.setName(name);
		dto.setStudentId(studentId);
		dto.setPhysics(physics);
		dto.setChemistry(chemistry);
		dto.setMaths(maths);

		return dto;
	}

}
