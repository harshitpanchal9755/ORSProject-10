package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.FacultyDaoInt;
import com.rays.dto.FacultyDto;

@Service
@Transactional
public class FacultyServiceImpl extends BaseServiceImpl<FacultyDto, FacultyDaoInt> implements FacultyServiceInt {

}
