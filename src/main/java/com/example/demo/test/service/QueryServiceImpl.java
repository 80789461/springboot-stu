package com.example.demo.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.PageAble;
import com.example.demo.common.PageInfo;
import com.example.demo.common.Result;
import com.example.demo.test.common.CourseStudentAbsentQueryDTO;
import com.example.demo.test.common.TodayAllCourseResultDTO;
import com.example.demo.test.dao.QueryDao;
@Service("queryService")
public class QueryServiceImpl implements QueryService {
	@Autowired
	QueryDao querDao;
	@Override
	public Result<PageAble<List<TodayAllCourseResultDTO>>> query(PageInfo pageInfo,CourseStudentAbsentQueryDTO dto) {
		// TODO Auto-generated method stub
		return Result.sucess(querDao.query(pageInfo,dto));
	}

}
