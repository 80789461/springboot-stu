package com.example.demo.test.service;

import java.util.List;

import com.example.demo.common.PageAble;
import com.example.demo.common.PageInfo;
import com.example.demo.common.Result;
import com.example.demo.test.common.CourseStudentAbsentQueryDTO;
import com.example.demo.test.common.TodayAllCourseResultDTO;

public interface QueryService {
	public Result<PageAble<List<TodayAllCourseResultDTO>>> query(PageInfo pageInfo,CourseStudentAbsentQueryDTO dto);
}
