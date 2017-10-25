package com.apik.person.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class DetailspersonController {

	@Autowired
	private PersonDAO personDao;
	
	@RequestMapping("/admin/details.do")
	public ModelAndView detailsprocess(@RequestParam("id") String id) {
		System.out.println("Detailsperson ����!");
		System.out.println("������ id : "+id);
		
		PersonCommand listperson=null;		     
        
        listperson=personDao.detailsperson(id);
        System.out.println("id : "+id+" �� ���� ������ ������");
    
        
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("member/05_admin_m_vi.move");
        mav.addObject("listperson", listperson);
        		
		return mav;
	}
}
