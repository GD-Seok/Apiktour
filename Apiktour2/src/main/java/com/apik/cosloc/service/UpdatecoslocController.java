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
	
	//�Ϲ� get��� ��û�� �޾��� �� -> ������ �̵�
	@RequestMapping(value ="/admin/updatecosloc.do",method = RequestMethod.GET) 
	public ModelAndView updateprocess(@ModelAttribute("coslocDto") CoslocCommand coslocDto) {
		System.out.println("�ܼ� Get �̵� ��� ����!");
		
		CoslocCommand listcosloc=new CoslocCommand();	     
        
        listcosloc=coslocDao.detailscosloc(coslocDto);
        System.out.println("cosnum "+listcosloc.getCosnum()+" �� ���� ������ ������");
        System.out.println("locnum "+listcosloc.getLocnum()+" �� ���� ������ ������");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cosloc/05_admin_cosloc_mo.move");
		mav.addObject("listcosloc", listcosloc);
		
		return mav;
	}
	
	//post �������� �����͸� ���� ��
	@RequestMapping(value = "/admin/updatecosloc.do", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("coslocDto") CoslocCommand coslocDto, BindingResult result) {
		System.out.println("POST ������� ���� �����!");
		CoslocCommand listcosloc= new CoslocCommand();
		listcosloc = coslocDto;
		
		coslocDao.updatecosloc(listcosloc);
		System.out.println("ȸ�� ���� ���� ��");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("cosloc/05_admin_cosloc_vi.move");
		mav.addObject("listcosloc", listcosloc);		
		return mav;		
	}
}
