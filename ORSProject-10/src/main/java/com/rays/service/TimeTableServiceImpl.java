package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.TimeTableDaoInt;
import com.rays.dto.TimeTableDto;

@Service
@Transactional
public class TimeTableServiceImpl extends BaseServiceImpl<TimeTableDto, TimeTableDaoInt> implements TimeTableServiceInt{

	

}
