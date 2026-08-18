package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.StudentDaoInt;
import com.rays.dto.StudentDto;

@Service
@Transactional
public class StudentServiceImpl extends BaseServiceImpl<StudentDto, StudentDaoInt> implements StudentServiceInt {

	
}
