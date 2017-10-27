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
	
		//POST방식과, GET 방식일 경우, redirect로 이동시킬지, POST일 경우, 처리를 할지 판단
		@RequestMapping("/admin/insertcosloc.do")
		public String submit(@ModelAttribute("coslocDto")CoslocCommand coslocDto,
																					BindingResult result){
			System.out.println("cosloccommand : "+coslocDto);
			try {
				coslocDao.insertcosloc(coslocDto);
				System.out.println("코스 정보 등록됨!");
			}catch(Exception e){e.printStackTrace();}
			return "redirect:05_admin_cosloc_se.do";
		}
		

}
