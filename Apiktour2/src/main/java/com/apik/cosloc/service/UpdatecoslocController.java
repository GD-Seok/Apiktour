package com.apik.cosloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.cosloc.command.CoslocCommand;
import com.apik.cosloc.dao.CoslocDAO;

@Controller
public class UpdatecoslocController {
	
	@Autowired
	CoslocDAO coslocDao;
	
	//일반 get방식 요청을 받았을 때 -> 페이지 이동
	@RequestMapping(value ="/admin/updatecosloc.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@ModelAttribute("coslocDto") CoslocCommand coslocDto) {
		System.out.println("단순 Get 이동 방식 동작!");
		
		CoslocCommand listcosloc=new CoslocCommand();	     
        
        listcosloc=coslocDao.detailscosloc(coslocDto);
        System.out.println("cosnum "+listcosloc.getCosnum()+" 에 대한 상세정보 가져옴");
        System.out.println("locnum "+listcosloc.getLocnum()+" 에 대한 상세정보 가져옴");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cosloc/05_admin_cosloc_mo.move");
		mav.addObject("listcosloc", listcosloc);
		
		return mav;
	}
	
	//post 형식으로 데이터를 보낼 때
	@RequestMapping(value = "/admin/updatecosloc.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("coslocDto") CoslocCommand coslocDto, BindingResult result) {
		System.out.println("POST 방식으로 동작 실행됨!");
		CoslocCommand listcosloc= new CoslocCommand();
		listcosloc = coslocDto;
		
		coslocDao.updatecosloc(listcosloc);
		System.out.println("회원 정보 수정 됨");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cosloc/05_admin_cosloc_vi.move");
		mav.addObject("listcosloc", listcosloc);		
		return mav;		
	}
}
