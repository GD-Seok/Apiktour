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
	
	//�Ϲ� get��� ��û�� �޾��� �� -> ������ �̵�
	@RequestMapping(value ="/admin/updatecourse.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@RequestParam("cosnum") String cosnum) {
		System.out.println("�ܼ� Get �̵� ��� ����!");
		
		CourseCommand listcourse=null;		     
        
        listcourse=courseDao.detailscourse(cosnum);
        System.out.println("cosnum : "+cosnum+" �� ���� ������ ������");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cos/05_admin_cos_mo.move");
		mav.addObject("listcourse", listcourse);
		
		return mav;
	}
	
	//post �������� �����͸� ���� ��
	@RequestMapping(value = "/admin/updatecourse.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("courseDto") CourseCommand courseDto, BindingResult result) {
		System.out.println("POST ������� ���� �����!");
		CourseCommand listcourse=null;
		listcourse = courseDto;
		
		courseDao.updatecourse(listcourse);
		System.out.println("ȸ�� ���� ���� ��");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cos/05_admin_cos_vi.move");
		mav.addObject("listcourse", listcourse);		
		return mav;		
	}
}
