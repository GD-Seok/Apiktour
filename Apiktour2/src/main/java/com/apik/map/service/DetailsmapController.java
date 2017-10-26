package com.apik.map.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.map.command.MapCommand;
import com.apik.map.dao.MapDAO;
import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class DetailsmapController {

	@Autowired
	private MapDAO mapDao;
	
	@RequestMapping("/admin/details.do")
	public ModelAndView detailsprocess(@RequestParam("id") String id) {
		System.out.println("Detailsperson 동작!");
		System.out.println("선택한 id : "+id);
		
		MapCommand listmap=null;		     
        
		listmap=mapDao.detailsmap(id);
        System.out.println("id : "+id+" 에 대한 상세정보 가져옴");
    
        
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("member/05_admin_map_vi.move");
        mav.addObject("listmap", listmap);
        		
		return mav;
	}
}
