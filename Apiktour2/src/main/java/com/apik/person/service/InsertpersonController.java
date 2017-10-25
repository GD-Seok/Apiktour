package com.apik.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class InsertpersonController {
		
		@Autowired
		PersonDAO personDao;
	
		//POST��İ�, GET ����� ���, redirect�� �̵���ų��, POST�� ���, ó���� ���� �Ǵ�
		@RequestMapping("/admin/insertperson.do")
		public String submit(@ModelAttribute("personDto")PersonCommand personDto,
																					BindingResult result){
			System.out.println("Personcommand : "+personDto);
			try {
				personDao.insertperson(personDto);
				System.out.println("ȸ�� ���� ��ϵ�!");
			}catch(Exception e){e.printStackTrace();}
			return "redirect:05_admin_m_se.do";
		}
		

}
