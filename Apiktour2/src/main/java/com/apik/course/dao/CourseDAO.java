package com.apik.course.dao;

import java.util.List;
import java.util.Map;
import com.apik.course.command.CourseCommand;

public interface CourseDAO {

	public int selectCosCount();
	
	public int getCourseCount(Map<String,Object> map);
	
	public List<CourseCommand> getCourseList(Map<String,Object> map);
	
	public List<CourseCommand> getCourseNumList(int cosnum);
	
	public int getCourseNumCount(int cosnumL);
	
	public List<CourseCommand> getCourseMarkerList(Map<String,Object> map);
	
	
}
