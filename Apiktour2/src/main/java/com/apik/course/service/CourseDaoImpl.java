package com.apik.course.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.apik.course.dao.CourseDAO;
import com.apik.course.command.CourseCommand;
import com.apik.course.command.CourseVO;

public class CourseDaoImpl extends SqlSessionDaoSupport implements CourseDAO {
	
	@Override
	public int selectCosCount() {
		// TODO Auto-generated method stub
		//int count=(Integer)getSqlSession().selectOne("selectCount");
		//return count;				
		return getSqlSession().selectOne("selectCosCount");
	}
	
	@Override
	public int getCourseCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCourseCount", map);
	}

	@Override
	public List<CourseCommand> getCourseList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		 List<CourseCommand> list=getSqlSession().selectList("selectCourseList", map);
		 return list;
	}
	
	@Override
	public List<CourseCommand> getCourseNumList(int cosnum) {
		List<CourseCommand> list=getSqlSession().selectList("selectCourseNumList", cosnum);
		return null;
	}

	@Override
	public int getCourseNumCount(int cosnumL) {
		return getSqlSession().selectOne("selectCourseNumCount", cosnumL);
	}

	@Override
	public List<CourseVO> getCourseMarkerList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<CourseVO> list=getSqlSession().selectList("selectCourseMarker", map);
		 return list;
	}

	
	
}
