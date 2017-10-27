package com.apik.cosloc.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apik.cosloc.command.CoslocCommand;
import com.apik.cosloc.dao.CoslocDAO;

@Controller
public class ListcoslocController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	CoslocDAO coslocDao;
	
	@RequestMapping("/admin/05_admin_cosloc_se.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ListcoslocControoler ȣ���!");
		
		if(log.isDebugEnabled()) { //���� �αװ�ü�� ���� Debug ���¶��
			System.out.println("process() ȣ���");			
		}
		
		

		//�˻��о�, �˻�� Map�� ��ƾ� �ȴ�.

        //�� ���� 
        int count=coslocDao.countcosloc();
        System.out.println("cosloc table�� count �� : "+count);
        
        List<CoslocCommand> listcosloc=null; //���ڵ� ���� ��ü ����
        
        if(count > 0) {
            listcosloc=coslocDao.listcosloc(); //4���� Ű���� ����
        }else {
            listcosloc=Collections.EMPTY_LIST;//������� ���� (�ƹ��͵� ����)
        }
    
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cosloc/05_admin_cosloc_se.move");
        mav.addObject("count", count);
        mav.addObject("listcosloc", listcosloc);
        
    
        return mav;

	}
}
