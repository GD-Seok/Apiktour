package com.apik.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class UpdatepersonController {
	
	@Autowired
	PersonDAO personDao;
	
	//일반 get방식 요청을 받았을 때 -> 페이지 이동
	@RequestMapping(value ="/admin/updateperson.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@RequestParam("id") String id) {
		System.out.println("단순 Get 이동 방식 동작!");
		
		PersonCommand listperson=null;		     
        
        listperson=personDao.detailsperson(id);
        System.out.println("id : "+id+" 에 대한 상세정보 가져옴");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/05_admin_m_mo.move");
		mav.addObject("listperson", listperson);
		
		return mav;
	}
	
	//post 형식으로 데이터를 보낼 때
	@RequestMapping(value = "/admin/updateperson.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("personDto") PersonCommand personDto, BindingResult result) {
		System.out.println("POST 방식으로 동작 실행됨!");
		PersonCommand listperson=null;
		listperson = personDto;
		
		personDao.updateperson(listperson);
		System.out.println("회원 정보 수정 됨");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/05_admin_m_vi.move");
		mav.addObject("listperson", listperson);		
		return mav;		
	}
}
