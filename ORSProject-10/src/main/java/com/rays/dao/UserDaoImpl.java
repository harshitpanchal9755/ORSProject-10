package com.rays.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDaoImpl;
import com.rays.common.UserContext;
import com.rays.dto.RoleDto;
import com.rays.dto.UserDto;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserDto> implements UserDaoInt {
	
	@Autowired
	RoleDaoInt roleDao;

	@Override
	public Class<UserDto> getDtoClass() {
		return UserDto.class;
	}
	
	@Override
	protected void populate(UserDto dto, UserContext userContext) {
		if (dto.getRoleId() != null && dto.getRoleId() > 0) {
			RoleDto roleDto = roleDao.findByPk(dto.getRoleId(), userContext);
			dto.setRoleName(roleDto.getName());
		}
		if (dto.getId() != null && dto.getId() > 0) {
			UserDto userData = findByPk(dto.getId(), userContext);
			dto.setLastLogin(userData.getLastLogin());
		}
	}

	@Override
	protected List<Predicate> getWhereClause(UserDto dto, CriteriaBuilder builder, Root<UserDto> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if(!isEmptyString(dto.getFirstName())) {
			whereCondition.add(builder.equal(qRoot.get("id"), qRoot));
		}
		
		if(!isEmptyString(dto.getLoginId())) {
			whereCondition.add(builder.like(qRoot.get("loginId"), dto.getLoginId() + "%"));
		}
		
		if (!isZeroNumber(dto.getRoleId())) {

			whereCondition.add(builder.equal(qRoot.get("roleId"), dto.getRoleId()));
		}
		if (isNotNull(dto.getDob())) {

			whereCondition.add(builder.equal(qRoot.get("dob"), dto.getDob()));
		}
		if (!isEmptyString(dto.getStatus())) {

			whereCondition.add(builder.equal(qRoot.get("status"), dto.getStatus()));
		}
		return whereCondition;
	
		
	}

}
