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
	
	//�Ϲ� get��� ��û�� �޾��� �� -> ������ �̵�
	@RequestMapping(value ="/admin/updatemap.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@RequestParam("locnum") String locnum) {
		System.out.println("�ܼ� Get �̵� ��� ����!");
		
		MapCommand listmap=null;		     
        
		listmap=mapDao.detailsmap(locnum);
        System.out.println("locnum : "+locnum+" �� ���� ������ ������");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("map/05_admin_map_mo.move");
		mav.addObject("listmap", listmap);
		
		return mav;
	}
	
	//post �������� �����͸� ���� ��
	@RequestMapping(value = "/admin/updatemap.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("mapDto") MapCommand mapDto, BindingResult result) {
		System.out.println("POST ������� ���� �����!");
		MapCommand listmap=null;
		listmap = mapDto;
		
		mapDao.updatemap(listmap);
		System.out.println("���� ���� ��");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("map/05_admin_map_vi.move");
		mav.addObject("listmap", listmap);		
		return mav;		
	}
}
