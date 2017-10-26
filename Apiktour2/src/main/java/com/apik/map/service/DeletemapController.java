package com.apik.map.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.map.dao.MapDAO;
import com.apik.person.dao.PersonDAO;

@Controller
public class DeletemapController {
	
	@Autowired
	MapDAO mapDao;
	
	@RequestMapping("/admin/deletemap.do")
	public ModelAndView deleteprocess(@RequestParam("locnum") String locnum) {
		System.out.println("deleteprocess 동작!");		
		
		mapDao.deletemap(locnum);
		System.out.println(locnum+"삭제 완료 ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:05_admin_map_se.do");
		
		return mav;
				
	}

}
