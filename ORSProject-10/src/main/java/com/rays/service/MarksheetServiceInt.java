package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceInt;
import com.rays.dto.MarksheetDto;

@Service
@Transactional
public interface MarksheetServiceInt extends BaseServiceInt<MarksheetDto>{

}
