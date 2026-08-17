package com.rays.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDto;

@Entity
@Table(name = "st_user")
public class UserDto extends BaseDto{
	
	public static final String ACTIVE = "Active";
	public static final String DEACTIVE = "Deactive";
	public static final String LOCKED = "Locked";

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "login_id", length = 50)
	private String loginId;

	@Column(name = "password", length = 50)
	private String password;

	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "role_name", length = 50)
	private String roleName = null;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "gender", length = 10)
	private String gender;

	@Column(name = "phone", length = 50)
	private String phone;

	@Column(name = "alternate_mobile", length = 50)
	private String alternateMobile;

	@Column(name = "status", length = 20)
	private String status;

	@Column(name = "last_login")
	private Timestamp lastLogin;

	@Column(name = "unsucess_login")
	private Integer unsucessfullLoginAttempt = 0;

	@Column(name = "image_id")
	private Long imageId;

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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAlternateMobile() {
		return alternateMobile;
	}

	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getUnsucessfullLoginAttempt() {
		return unsucessfullLoginAttempt;
	}

	public void setUnsucessfullLoginAttempt(Integer unsucessfullLoginAttempt) {
		this.unsucessfullLoginAttempt = unsucessfullLoginAttempt;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	@Override
	public String getUniqueKey() {
		return "loginId";
	}

	@Override
	public String getUniqueValue() {
		return loginId;
	}

	@Override
	public String getLabel() {
		return "Login Id";
	}
	
	@Override
	public String getTableName() {
		return "User";
	}

	@Override
	public String getValue() {
		return null;
	}

}
