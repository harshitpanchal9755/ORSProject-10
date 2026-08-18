package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDto;

@Entity
@Table(name = "st_student")
public class StudentDto extends BaseDto{

	@Column(name = "enrol_no", length = 20)
	private String enrolNo;

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "phone_no", length = 15)
	private String phoneNo;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "college_id")
	private Long collegeId;

	@Column(name = "college_name", length = 50)
	private String collegeName;

	public String getEnrolNo() {
		return enrolNo;
	}

	public void setEnrolNo(String enrolNo) {
		this.enrolNo = enrolNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String getUniqueKey() {
		return "enrolNo";
	}

	@Override
	public String getUniqueValue() {
		return enrolNo;
	}

	@Override
	public String getLabel() {
		return "Enroll No";
	}
	
	@Override
	public String getTableName() {
		return "Student";
	}

	@Override
	public String getValue() {
		return firstName + " " + lastName;
	}
}
