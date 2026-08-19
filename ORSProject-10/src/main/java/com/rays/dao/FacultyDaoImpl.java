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
import com.rays.dto.CourseDto;
import com.rays.dto.FacultyDto;
import com.rays.dto.SubjectDto;

@Repository
public class FacultyDaoImpl extends BaseDaoImpl<FacultyDto> implements FacultyDaoInt {

	@Autowired
	CollegeDaoInt collegeDao;

	@Autowired
	CourseDaoInt courseDao;

	@Autowired
	SubjectDaoInt subjectDao;

	@Override
	public Class<FacultyDto> getDtoClass() {
		return FacultyDto.class;
	}

	@Override
	protected void populate(FacultyDto dto, UserContext userContext) {

		if (dto.getCollegeId() > 0) {
			CollegeDto collegeDto = collegeDao.findByPk(dto.getCollegeId(), userContext);
			dto.setCollegeName(collegeDto.getName());
		}
		if (dto.getCourseId() > 0) {
			CourseDto courseDto = courseDao.findByPk(dto.getCourseId(), userContext);
			dto.setCourseName(courseDto.getName());
		}
		if (dto.getSubjectId() > 0) {
			SubjectDto subjectDto = subjectDao.findByPk(dto.getSubjectId(), userContext);
			dto.setSubjectName(subjectDto.getName());
		}
	}

	@Override
	protected List<Predicate> getWhereClause(FacultyDto dto, CriteriaBuilder builder, Root<FacultyDto> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getFirstName())) {

			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
		}

		if (!isEmptyString(dto.getEmail())) {

			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
		}

		if (!isEmptyString(dto.getCollegeName())) {

			whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
		}

		if (!isEmptyString(dto.getCourseName())) {

			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}

		if (!isEmptyString(dto.getSubjectName())) {

			whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
		}

		return whereCondition;
	}

}
