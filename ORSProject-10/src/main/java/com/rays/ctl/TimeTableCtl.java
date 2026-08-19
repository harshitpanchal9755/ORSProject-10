package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.TimeTableDto;
import com.rays.form.TimeTableForm;
import com.rays.service.TimeTableServiceInt;

@RestController
@RequestMapping(value = "TimeTable")
public class TimeTableCtl extends BaseCtl<TimeTableForm, TimeTableDto, TimeTableServiceInt>{

}
