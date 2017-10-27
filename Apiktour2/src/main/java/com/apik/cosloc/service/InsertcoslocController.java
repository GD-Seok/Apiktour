package com.apik.cosloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apik.cosloc.command.CoslocCommand;
import com.apik.cosloc.dao.CoslocDAO;

@Controller
public class InsertcoslocController {
		
		@Autowired
		CoslocDAO coslocDao;
	
		//POST��İ�, GET ����� ���, redirect�� �̵���ų��, POST�� ���, ó���� ���� �Ǵ�
		@RequestMapping("/admin/insertcosloc.do")
		public String submit(@ModelAttribute("coslocDto")CoslocCommand coslocDto,
																					BindingResult result){
			System.out.println("cosloccommand : "+coslocDto);
			try {
				coslocDao.insertcosloc(coslocDto);
				System.out.println("�ڽ� ���� ��ϵ�!");
			}catch(Exception e){e.printStackTrace();}
			return "redirect:05_admin_cosloc_se.do";
		}
		

}
