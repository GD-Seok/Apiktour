package com.apik.course.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apik.course.command.CourseCommand;
import com.apik.course.dao.CourseDAO;

@Controller
public class ListcourseController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	CourseDAO courseDao;
	
	@RequestMapping("/admin/05_admin_cos_se.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ListcourseControoler ȣ���!");
		
		if(log.isDebugEnabled()) { //���� �αװ�ü�� ���� Debug ���¶��
			System.out.println("process() ȣ���");			
		}
		
		

		//�˻��о�, �˻�� Map�� ��ƾ� �ȴ�.

        //�� ���� 
        int count=courseDao.countcourse();
        System.out.println("course table�� count �� : "+count);
        
        List<CourseCommand> listcourse=null; //���ڵ� ���� ��ü ����
        
        if(count > 0) {
            listcourse=courseDao.listcourse(); //4���� Ű���� ����
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
