package com.apik.map.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.map.command.MapCommand;
import com.apik.map.dao.MapDAO;
import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class UpdatemapController {
	
	@Autowired
	MapDAO mapDao;
	
	//일반 get방식 요청을 받았을 때 -> 페이지 이동
	@RequestMapping(value ="/admin/updatemap.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@RequestParam("locnum") String locnum) {
		System.out.println("단순 Get 이동 방식 동작!");
		
		MapCommand listmap=null;		     
        
		listmap=mapDao.detailsmap(locnum);
        System.out.println("locnum : "+locnum+" 에 대한 상세정보 가져옴");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("map/05_admin_map_mo.move");
		mav.addObject("listmap", listmap);
		
		return mav;
	}
	
	//post 형식으로 데이터를 보낼 때
	@RequestMapping(value = "/admin/updatemap.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("mapDto") MapCommand mapDto, BindingResult result) {
		System.out.println("POST 방식으로 동작 실행됨!");
		MapCommand listmap=null;
		listmap = mapDto;
		
		mapDao.updatemap(listmap);
		System.out.println("정보 수정 됨");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("map/05_admin_map_vi.move");
		mav.addObject("listmap", listmap);		
		return mav;		
	}
}
