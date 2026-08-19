package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDto;
import com.rays.dto.SubjectDto;
import com.rays.dto.TimeTableDto;
import com.rays.form.TimeTableForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;
import com.rays.service.TimeTableServiceInt;

@RestController
@RequestMapping(value = "TimeTable")
public class TimeTableCtl extends BaseCtl<TimeTableForm, TimeTableDto, TimeTableServiceInt>{
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	@GetMapping("preload")
	public ORSResponse preload() {
	ORSResponse res = new ORSResponse(true);
	List<CourseDto> list = courseService.search(new CourseDto(), userContext);
	List<SubjectDto> list1= subjectService.search(new SubjectDto(), userContext);
	res.addResult("courseList", list);
	res.addResult("subjectList", list1);
	return res;
	}

}
