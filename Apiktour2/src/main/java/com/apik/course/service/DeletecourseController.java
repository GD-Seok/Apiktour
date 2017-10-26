package com.apik.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.course.dao.CourseDAO;

@Controller
public class DeletecourseController {
	
	@Autowired
	CourseDAO courseDao;
	
	@RequestMapping("/admin/deletecourse.do")
	public ModelAndView deleteprocess(@RequestParam("cosnum") String cosnum) {
		System.out.println("deleteprocess 동작!");		
		
		courseDao.deletecourse(cosnum);
		System.out.println(cosnum+" 코스 삭제 완료 ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:05_admin_cos_se.do");
		
		return mav;
				
	}

}
