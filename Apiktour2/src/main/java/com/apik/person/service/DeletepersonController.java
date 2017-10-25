package com.apik.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.person.dao.PersonDAO;

@Controller
public class DeletepersonController {
	
	@Autowired
	PersonDAO personDao;
	
	@RequestMapping("/admin/deleteperson.do")
	public ModelAndView deleteprocess(@RequestParam("id") String id) {
		System.out.println("deleteprocess 동작!");		
		
		personDao.deleteperson(id);
		System.out.println(id+" 회원 삭제 완료 ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:05_admin_m_se.do");
		
		return mav;
				
	}

}
