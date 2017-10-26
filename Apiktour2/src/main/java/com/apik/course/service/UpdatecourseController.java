package com.apik.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.course.command.CourseCommand;
import com.apik.course.dao.CourseDAO;

@Controller
public class UpdatecourseController {
	
	@Autowired
	CourseDAO courseDao;
	
	//일반 get방식 요청을 받았을 때 -> 페이지 이동
	@RequestMapping(value ="/admin/updatecourse.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@RequestParam("cosnum") String cosnum) {
		System.out.println("단순 Get 이동 방식 동작!");
		
		CourseCommand listcourse=null;		     
        
        listcourse=courseDao.detailscourse(cosnum);
        System.out.println("cosnum : "+cosnum+" 에 대한 상세정보 가져옴");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cos/05_admin_cos_mo.move");
		mav.addObject("listcourse", listcourse);
		
		return mav;
	}
	
	//post 형식으로 데이터를 보낼 때
	@RequestMapping(value = "/admin/updatecourse.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("courseDto") CourseCommand courseDto, BindingResult result) {
		System.out.println("POST 방식으로 동작 실행됨!");
		CourseCommand listcourse=null;
		listcourse = courseDto;
		
		courseDao.updatecourse(listcourse);
		System.out.println("회원 정보 수정 됨");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cos/05_admin_cos_vi.move");
		mav.addObject("listcourse", listcourse);		
		return mav;		
	}
}
