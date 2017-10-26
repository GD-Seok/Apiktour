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
	
	@RequestMapping("/admin/detailsmap.do")
	public ModelAndView detailsprocess(@RequestParam("locnum") String locnum) {
		System.out.println("Detailsperson ����!");
		System.out.println("������ locnum : "+locnum);
		
		MapCommand listmap=null;		     
        
		listmap=mapDao.detailsmap(locnum);
        System.out.println("locnum : "+locnum+" �� ���� ������ ������");
    
        
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("map/05_admin_map_vi.move");
        mav.addObject("listmap", listmap);
        		
		return mav;
	}
}
