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
	
	//�Ϲ� get��� ��û�� �޾��� �� -> ������ �̵�
	@RequestMapping(value ="/admin/updateperson.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@RequestParam("id") String id) {
		System.out.println("�ܼ� Get �̵� ��� ����!");
		
		PersonCommand listperson=null;		     
        
        listperson=personDao.detailsperson(id);
        System.out.println("id : "+id+" �� ���� ������ ������");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/05_admin_m_mo.move");
		mav.addObject("listperson", listperson);
		
		return mav;
	}
	
	//post �������� �����͸� ���� ��
	@RequestMapping(value = "/admin/updateperson.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("personDto") PersonCommand personDto, BindingResult result) {
		System.out.println("POST ������� ���� �����!");
		PersonCommand listperson=null;
		listperson = personDto;
		
		personDao.updateperson(listperson);
		System.out.println("ȸ�� ���� ���� ��");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/05_admin_m_vi.move");
		mav.addObject("listperson", listperson);		
		return mav;		
	}
}
