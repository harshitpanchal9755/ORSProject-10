package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.MarksheetDaoInt;
import com.rays.dto.MarksheetDto;
@Service
@Transactional
public class MarksheetServiceImpl extends BaseServiceImpl<MarksheetDto, MarksheetDaoInt> implements MarksheetServiceInt{

}
