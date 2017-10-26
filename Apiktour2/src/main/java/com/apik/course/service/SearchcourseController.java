package com.apik.course.service;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.course.command.CourseCommand;
import com.apik.course.dao.CourseDAO;

@Controller
public class SearchcourseController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	CourseDAO courseDao;

	@RequestMapping("/admin/searchcourse.do")
	public ModelAndView searchprocess(@RequestParam("keyField") String keyField,
															@RequestParam("keyWord") String keyWord) throws Exception{
		System.out.println("ȸ�� ��� �˻� SearchcourseController ����!");
		
        CourseCommand courseDto = new CourseCommand();
        courseDto.setKeyField(keyField);
        courseDto.setKeyWord(keyWord);
        
		//�� ���� 
        int count=courseDao.countsearchcourse(courseDto);
        System.out.println("�˻��� course table�� count �� : "+count);
        
		List<CourseCommand> listcourse=null;
						
		if(count > 0) {			
            listcourse=courseDao.searchcourse(courseDto);
        }else {
            listcourse=Collections.EMPTY_LIST;//������� ���� (�ƹ��͵� ����)
        }
		
		ModelAndView mav = new ModelAndView();
        mav.setViewName("cos/05_admin_cos_se.move");
        mav.addObject("count", count);
        mav.addObject("listcourse", listcourse);
		
		return mav;
	}
}
