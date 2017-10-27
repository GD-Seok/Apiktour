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
	
	//�Ϲ� get��� ��û�� �޾��� �� -> ������ �̵�
	@RequestMapping(value ="/admin/updateicontype.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@RequestParam("loctype") String loctype) {
		System.out.println("�ܼ� Get �̵� ��� ����!");
		
		IcontypeCommand listicontype=null;		     
        
        listicontype=icontypeDao.detailsicontype(loctype);
        System.out.println("loctype : "+loctype+" �� ���� ������ ������");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("icontype/05_admin_icon_mo.move");
		mav.addObject("listicontype", listicontype);
		
		return mav;
	}
	
	//post �������� �����͸� ���� ��
	@RequestMapping(value = "/admin/updateicontype.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("icontypeDto") IcontypeCommand icontypeDto, BindingResult result) {
		System.out.println("POST ������� ���� �����!");
		IcontypeCommand listicontype=null;
		listicontype = icontypeDto;
		
		icontypeDao.updateicontype(listicontype);
		System.out.println("ȸ�� ���� ���� ��");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("icontype/05_admin_icon_vi.move");
		mav.addObject("listicontype", listicontype);		
		return mav;		
	}
}
