package com.example.demo.test.mapper;

import java.util.List;

import com.example.demo.test.common.CourseStudentAbsentQueryDTO;
import com.example.demo.test.common.TodayAllCourseResultDTO;

public interface TodayAllCourseMapper {
	public List<TodayAllCourseResultDTO> query(CourseStudentAbsentQueryDTO dto);
}
