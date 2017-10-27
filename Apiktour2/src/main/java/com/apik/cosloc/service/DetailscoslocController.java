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
public class DetailscoslocController {

	@Autowired
	private CoslocDAO coslocDao;
	
	@RequestMapping("/admin/detailscosloc.do")
	public ModelAndView detailsprocess(@ModelAttribute("coslocDto")CoslocCommand coslocDto) {
		System.out.println("Detailscosloc ����!");
				
		CoslocCommand listcosloc=null;		     
        
        listcosloc=coslocDao.detailscosloc(coslocDto);
        System.out.println("������ cosnum : "+listcosloc.getCosnum());
        System.out.println("cosnum : "+listcosloc.getCosnum()+" �� ���� ������ ������");
    
        
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("cosloc/05_admin_cosloc_vi.move");
        mav.addObject("listcosloc", listcosloc);
        		
		return mav;
	}
}
