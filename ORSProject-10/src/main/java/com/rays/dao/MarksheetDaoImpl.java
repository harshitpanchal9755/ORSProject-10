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
import com.rays.dto.MarksheetDto;
import com.rays.dto.StudentDto;

@Repository
public class MarksheetDaoImpl extends BaseDaoImpl<MarksheetDto> implements MarksheetDaoInt {

	@Autowired
	StudentDaoInt studentDao = null;

	@Override
	public Class<MarksheetDto> getDtoClass() {
		return MarksheetDto.class;
	}

	@Override
	protected void populate(MarksheetDto dto, UserContext userContext) {
		if (dto.getStudentId() != null) {
			StudentDto studentDTO = studentDao.findByPk(dto.getStudentId(), userContext);
			if (studentDTO != null) {
				dto.setName(studentDTO.getFirstName() + " " + studentDTO.getLastName());
			}
		}
	}

	@Override
	protected List<Predicate> getWhereClause(MarksheetDto dto, CriteriaBuilder builder, Root<MarksheetDto> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getRollNo())) {

			whereCondition.add(builder.like(qRoot.get("rollNo"), dto.getRollNo() + "%"));
		}

		if (!isZeroNumber(dto.getStudentId())) {

			whereCondition.add(builder.equal(qRoot.get("studentId"), dto.getStudentId()));
		}

		return whereCondition;
	}

}
