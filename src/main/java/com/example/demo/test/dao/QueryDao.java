package com.example.demo.test.dao;

import java.util.List;

import com.example.demo.common.PageAble;
import com.example.demo.common.PageInfo;
import com.example.demo.test.common.CourseStudentAbsentQueryDTO;
import com.example.demo.test.common.TodayAllCourseResultDTO;

public interface QueryDao {
	public PageAble<List<TodayAllCourseResultDTO>> query(PageInfo pageInfo,CourseStudentAbsentQueryDTO dto);
}
