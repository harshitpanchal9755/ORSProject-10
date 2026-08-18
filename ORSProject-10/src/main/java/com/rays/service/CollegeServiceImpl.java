package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CollegeDaoInt;
import com.rays.dto.CollegeDto;

@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceImpl<CollegeDto, CollegeDaoInt> implements CollegeServiceInt{
	
	
	

}
