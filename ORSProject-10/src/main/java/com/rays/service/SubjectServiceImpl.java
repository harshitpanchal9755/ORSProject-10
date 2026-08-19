package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.SubjectDaoInt;
import com.rays.dto.SubjectDto;

@Service
@Transactional
public class SubjectServiceImpl extends BaseServiceImpl<SubjectDto, SubjectDaoInt> implements SubjectServiceInt{

}
