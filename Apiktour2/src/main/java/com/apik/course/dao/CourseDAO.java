package com.apik.course.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.apik.course.command.CourseCommand;
import com.apik.course.command.CourseVO;

public interface CourseDAO {

	public int selectCosCount();

	public int getCourseCount(Map<String, Object> map);

	public List<CourseCommand> getCourseList(Map<String, Object> map);

	public List<CourseVO> getCourseNumList(int cosnum);

	public int getCourseNumCount(int cosnumL);

	public List<CourseVO> getCourseMarkerList(Map<String, Object> map);

	// ������ ������
	// 0.�ڽ� �˻� (searchcourse)
	public List<CourseCommand> searchcourse(CourseCommand courseDto) throws DataAccessException;
	// 1.�ڽ� ��� (listcourse)
	public List<CourseCommand> listcourse() throws DataAccessException;
	public int countcourse() throws DataAccessException;
	public int countsearchcourse(CourseCommand courseDto) throws DataAccessException;
	// 3. �ڽ� ��� (insertcourse)
	public void insertcourse(CourseCommand courseDto) throws DataAccessException;
	// 4. �ڽ� ���� (updatecourse)
	public void updatecourse(CourseCommand courseDto) throws DataAccessException;
	// 6. �ڽ� ���� (deletecourse)
	public void deletecourse(String cosnum) throws DataAccessException;
	// 7.�ڽ� ������
	public CourseCommand detailscourse(String cosnum) throws DataAccessException;

}
