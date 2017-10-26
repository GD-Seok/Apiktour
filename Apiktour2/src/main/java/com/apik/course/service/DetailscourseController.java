package com.apik.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.course.command.CourseCommand;
import com.apik.course.dao.CourseDAO;

@Controller
public class DetailscourseController {

	@Autowired
	private CourseDAO courseDao;
	
	@RequestMapping("/admin/detailscourse.do")
	public ModelAndView detailsprocess(@RequestParam("cosnum") String cosnum) {
		System.out.println("Detailscourse ����!");
		System.out.println("������ cosnum : "+cosnum);
		
		CourseCommand listcourse=null;		     
        
        listcourse=courseDao.detailscourse(cosnum);
        System.out.println("cosnum : "+cosnum+" �� ���� ������ ������");
    
        
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("cos/05_admin_cos_vi.move");
        mav.addObject("listcourse", listcourse);
        		
		return mav;
	}
}
