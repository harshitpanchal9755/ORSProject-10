package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseDto implements DropdownList {

	@Id
	@GeneratedValue(generator = "harshitPk")
	@GenericGenerator(name = "harshitPk", strategy = "native")
	@Column(name = "id", unique = true, nullable = false)
	protected Long id;

	@Column(name = "created_by", length = 50)
	protected String createdBy = "root";

	@Column(name = "modified_by", length = 50)
	protected String modifiedBy = "root";

	@Column(name = "created_datetime")
	protected Timestamp createdDatetime;

	@Column(name = "modified_datetime")
	protected Timestamp modifiedDatetime;

	public abstract String getUniqueKey();

	public abstract String getUniqueValue();

	public abstract String getLabel();

	public abstract String getTableName();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

}