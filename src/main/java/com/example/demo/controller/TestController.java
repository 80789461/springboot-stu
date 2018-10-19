package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.Result;
import com.example.demo.common.PageAble;
import com.example.demo.common.PageInfo;
import com.example.demo.common.ParamVilidator;
import com.example.demo.controller.form.UserForm;
import com.example.demo.test.common.CourseStudentAbsentQueryDTO;
import com.example.demo.test.common.TodayAllCourseResultDTO;
import com.example.demo.test.service.QueryService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private QueryService queryService;
	
	@RequestMapping(value="/index",method=RequestMethod.POST)
	@ParamVilidator(index= {"1","2"})
	public Result<PageAble<List<TodayAllCourseResultDTO>>> teste(@RequestBody UserForm userForm) {
		PageInfo pageInfo = new PageInfo(1,20);
		CourseStudentAbsentQueryDTO dto = new CourseStudentAbsentQueryDTO();
		return queryService.query(pageInfo, dto);
	}
}
