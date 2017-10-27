package com.apik.icontype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.icontype.dao.IcontypeDAO;

@Controller
public class DeleteicontypeController {
	
	@Autowired
	IcontypeDAO icontypeDao;
	
	@RequestMapping("/admin/deleteicontype.do")
	public ModelAndView deleteprocess(@RequestParam("loctype") String loctype) {
		System.out.println("deleteprocess 동작!");		
		
		icontypeDao.deleteicontype(loctype);
		System.out.println(loctype+" 아이콘 삭제 완료 ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:05_admin_icon_se.do");
		
		return mav;
				
	}

}
