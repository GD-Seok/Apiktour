package com.apik.icontype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.icontype.command.IcontypeCommand;
import com.apik.icontype.dao.IcontypeDAO;

@Controller
public class UpdateicontypeController {
	
	@Autowired
	IcontypeDAO icontypeDao;
	
	//일반 get방식 요청을 받았을 때 -> 페이지 이동
	@RequestMapping(value ="/admin/updateicontype.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@RequestParam("loctype") String loctype) {
		System.out.println("단순 Get 이동 방식 동작!");
		
		IcontypeCommand listicontype=null;		     
        
        listicontype=icontypeDao.detailsicontype(loctype);
        System.out.println("loctype : "+loctype+" 에 대한 상세정보 가져옴");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("icontype/05_admin_icon_mo.move");
		mav.addObject("listicontype", listicontype);
		
		return mav;
	}
	
	//post 형식으로 데이터를 보낼 때
	@RequestMapping(value = "/admin/updateicontype.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("icontypeDto") IcontypeCommand icontypeDto, BindingResult result) {
		System.out.println("POST 방식으로 동작 실행됨!");
		IcontypeCommand listicontype=null;
		listicontype = icontypeDto;
		
		icontypeDao.updateicontype(listicontype);
		System.out.println("회원 정보 수정 됨");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("icontype/05_admin_icon_vi.move");
		mav.addObject("listicontype", listicontype);		
		return mav;		
	}
}
