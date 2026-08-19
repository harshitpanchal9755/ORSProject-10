package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDaoImpl;
import com.rays.dto.CourseDto;

@Repository
public class CourseDaoImpl extends BaseDaoImpl<CourseDto> implements CourseDaoInt {

	@Override
	public Class<CourseDto> getDtoClass() {
		// TODO Auto-generated method stub
		return CourseDto.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CourseDto dto, CriteriaBuilder builder, Root<CourseDto> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getDescription())) {

			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}

		if (!isEmptyString(dto.getDuration())) {

			whereCondition.add(builder.like(qRoot.get("duration"), dto.getDuration() + "%"));
		}

		return whereCondition;
	}
	}

