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
import com.rays.dto.TimeTableDto;

@Repository
public class TimeTableDaoImpl extends BaseDaoImpl<TimeTableDto> implements TimeTableDaoInt {

	@Autowired
	SubjectDaoInt subjectService;

	@Autowired
	CourseDaoInt courseService;

	@Override
	public Class<TimeTableDto> getDtoClass() {
		return TimeTableDto.class;
	}

	@Override
	protected void populate(TimeTableDto dto, UserContext userContext) {

		SubjectDto subjectDto = subjectService.findByPk(dto.getSubjectId(), userContext);
		if (subjectDto != null) {
			dto.setSubjectName(subjectDto.getName());
		}

		CourseDto courseDto = courseService.findByPk(dto.getCourseId(), userContext);
		if (courseDto != null) {
			dto.setCourseName(courseDto.getName());
			
		}
	}

	@Override
	protected List<Predicate> getWhereClause(TimeTableDto dto, CriteriaBuilder builder, Root<TimeTableDto> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getSubjectName())) {

			whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
		}
		if (!isEmptyString(dto.getCourseName())) {

			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}
		return whereCondition;
	}
}
