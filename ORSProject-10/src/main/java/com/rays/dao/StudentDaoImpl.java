package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDaoImpl;
import com.rays.common.UserContext;
import com.rays.dto.CollegeDto;
import com.rays.dto.StudentDto;

@Repository
public class StudentDaoImpl extends BaseDaoImpl<StudentDto> implements StudentDaoInt {

	@Autowired
	CollegeDaoInt collegeService = null;

	@Override
	public Class<StudentDto> getDtoClass() {
		return StudentDto.class;
	}

	@Override
	protected void populate(StudentDto dto, UserContext userContext) {
		CollegeDto collegeDto = collegeService.findByPk(dto.getCollegeId(), userContext);
		if (collegeDto != null) {
			dto.setCollegeName(collegeDto.getName());
		}
	}

	@Override
	protected List<Predicate> getWhereClause(StudentDto dto, CriteriaBuilder builder, Root<StudentDto> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getEnrolNo())) {

			whereCondition.add(builder.like(qRoot.get("enrolNo"), dto.getEnrolNo() + "%"));
		}

		if (!isEmptyString(dto.getFirstName())) {

			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
		}

		if (!isEmptyString(dto.getCollegeName())) {

			whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
		}

		if (!isEmptyString(dto.getEmail())) {

			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
		}

		if (isNotNull(dto.getDob())) {

			whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
		}

		if (!isEmptyString(dto.getPhoneNo())) {
			whereCondition.add(builder.like(qRoot.get("phoneNo"), dto.getPhoneNo() + "%"));
		}

		return whereCondition;

	}
}
