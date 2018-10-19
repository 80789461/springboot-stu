package com.example.demo.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.common.PageAble;
import com.example.demo.common.PageInfo;
import com.example.demo.test.common.CourseStudentAbsentQueryDTO;
import com.example.demo.test.common.TodayAllCourseResultDTO;
import com.example.demo.test.mapper.TodayAllCourseMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
@Repository
public class QueryDaoImpl implements QueryDao {
	
	@Autowired
	TodayAllCourseMapper todayAllCourseMapper;
	
	@Override
	public PageAble<List<TodayAllCourseResultDTO>> query(PageInfo pageInfo,CourseStudentAbsentQueryDTO dto) {
		PageHelper.startPage(pageInfo.getCurrentPage(), pageInfo.getPageSize());
		Page<TodayAllCourseResultDTO> resutl = (Page<TodayAllCourseResultDTO>)todayAllCourseMapper.query(dto);
		return new PageAble<>(resutl.getResult(),pageInfo,resutl.getTotal());
	}
}
