package com.example.demo.controller;
import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.PageAble;
import com.example.demo.common.PageInfo;
import com.example.demo.common.Result;
import com.example.demo.controller.form.UserForm;
import com.example.demo.test.common.CourseStudentAbsentQueryDTO;
import com.example.demo.test.common.TodayAllCourseResultDTO;
import com.example.demo.test.service.QueryService;

@RestController
@RequestMapping("/api")
public class TestController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QueryService queryService;
	
	@RequestMapping(value="/index",method=RequestMethod.POST)
	public Result<PageAble<List<TodayAllCourseResultDTO>>> teste(@RequestBody UserForm userForm) {
		
		PageInfo pageInfo = new PageInfo(1,20);
		CourseStudentAbsentQueryDTO dto = new CourseStudentAbsentQueryDTO();
		return queryService.query(pageInfo, dto);
	}
	
	
}
