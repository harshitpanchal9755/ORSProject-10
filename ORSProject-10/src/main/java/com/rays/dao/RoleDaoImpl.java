package com.rays.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDaoImpl;
import com.rays.common.BaseDaoInt;
import com.rays.common.BaseDto;
import com.rays.common.UserContext;
import com.rays.dto.RoleDto;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<RoleDto> implements RoleDaoInt{

	@Override
	public Class<RoleDto> getDTOClass() {
		return RoleDto.class;
	}

	@Override
	protected List<Predicate> getWhereClause(RoleDto dto, CriteriaBuilder builder, Root<RoleDto> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if(!isZeroNumber(dto.getId())) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}
		
		if(!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			
		}
		return whereCondition;
	}




}