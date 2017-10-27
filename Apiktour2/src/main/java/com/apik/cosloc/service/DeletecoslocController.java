package com.apik.cosloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.cosloc.command.CoslocCommand;
import com.apik.cosloc.dao.CoslocDAO;

@Controller
public class DeletecoslocController {
	
	@Autowired
	CoslocDAO coslocDao;
	
	@RequestMapping("/admin/deletecosloc.do")
	public ModelAndView deleteprocess(@ModelAttribute("coslocDto")CoslocCommand coslocDto) {
		System.out.println("deleteprocess 동작!");		
		
		coslocDao.deletecosloc(coslocDto);
		System.out.println(" 코스 장소 삭제 완료 ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:05_admin_cosloc_se.do");
		
		return mav;
				
	}

}
