package com.apik.icontype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apik.icontype.command.IcontypeCommand;
import com.apik.icontype.dao.IcontypeDAO;

@Controller
public class InserticontypeController {
		
		@Autowired
		IcontypeDAO icontypeDao;
	
		//POST��İ�, GET ����� ���, redirect�� �̵���ų��, POST�� ���, ó���� ���� �Ǵ�
		@RequestMapping("/admin/inserticontype.do")
		public String submit(@ModelAttribute("icontypeDto")IcontypeCommand icontypeDto,
																					BindingResult result){
			System.out.println("icontypecommand : "+icontypeDto);
			try {
				icontypeDao.inserticontype(icontypeDto);
				System.out.println("������ ���� ��ϵ�!");
			}catch(Exception e){e.printStackTrace();}
			return "redirect:05_admin_icon_se.do";
		}
		

}
