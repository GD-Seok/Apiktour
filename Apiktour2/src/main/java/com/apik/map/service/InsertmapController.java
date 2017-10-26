package com.apik.map.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apik.map.command.MapCommand;
import com.apik.map.dao.MapDAO;
import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class InsertmapController {
		
		@Autowired
		MapDAO mapDao;
	
		//POST��İ�, GET ����� ���, redirect�� �̵���ų��, POST�� ���, ó���� ���� �Ǵ�
		@RequestMapping("/admin/insertmap.do")
		public String submit(@ModelAttribute("mapDto")MapCommand mapDto,
																					BindingResult result){
			System.out.println("MapCommand : "+mapDto);
			try {
				mapDto.insertmap(mapDto);
				System.out.println("ȸ�� ���� ��ϵ�!");
			}catch(Exception e){e.printStackTrace();}
			return "redirect:05_admin_map_se.do";
		}
		

}
