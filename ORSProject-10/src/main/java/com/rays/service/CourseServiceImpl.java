package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CourseDaoInt;
import com.rays.dto.CourseDto;

@Service
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<CourseDto, CourseDaoInt> implements CourseServiceInt{

}
