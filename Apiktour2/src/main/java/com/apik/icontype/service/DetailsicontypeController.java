package com.apik.icontype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.icontype.command.IcontypeCommand;
import com.apik.icontype.dao.IcontypeDAO;

@Controller
public class DetailsicontypeController {

	@Autowired
	private IcontypeDAO icontypeDao;
	
	@RequestMapping("/admin/detailsicontype.do")
	public ModelAndView detailsprocess(@RequestParam("loctype") String loctype) {
		System.out.println("Detailsicontype ����!");
		System.out.println("������ loctype : "+loctype);
		
		IcontypeCommand listicontype=null;		     
        
        listicontype=icontypeDao.detailsicontype(loctype);
        System.out.println("loctype : "+loctype+" �� ���� ������ ������");
    
        
        ModelAndView mav = new ModelAndView();
        
        mav.setViewName("icontype/05_admin_icon_vi.move");
        mav.addObject("listicontype", listicontype);
        		
		return mav;
	}
}
