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
import com.rays.dto.CourseDto;
import com.rays.dto.SubjectDto;

@Repository
public class SubjectDaoImpl extends BaseDaoImpl<SubjectDto> implements SubjectDaoInt{

	@Autowired
	CourseDaoInt courseDao;
	
	@Override
	protected void populate(SubjectDto dto, UserContext userContext) {
		if (dto.getCourseId() != 0) {
			CourseDto courseDto = courseDao.findByPk(dto.getCourseId(), userContext);
			if (courseDto != null) {
				dto.setCourseName(courseDto.getName());
			}
		}
		}
	
	@Override
	public Class<SubjectDto> getDtoClass() {
		// TODO Auto-generated method stub
		return SubjectDto.class;
	}

	@Override
	protected List<Predicate> getWhereClause(SubjectDto dto, CriteriaBuilder builder, Root<SubjectDto> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getCourseName())) {

			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}

		return whereCondition;
	}
	}
	
