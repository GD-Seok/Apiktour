package com.apik.icontype.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apik.icontype.command.IcontypeCommand;
import com.apik.icontype.dao.IcontypeDAO;

@Controller
public class ListicontypeController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	IcontypeDAO icontypeDao;
	
	@RequestMapping("/admin/05_admin_icon_se.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ListicontypeControoler ȣ���!");
		
		if(log.isDebugEnabled()) { //���� �αװ�ü�� ���� Debug ���¶��
			System.out.println("process() ȣ���");			
		}
		
		

		//�˻��о�, �˻�� Map�� ��ƾ� �ȴ�.

        //�� ���� 
        int count=icontypeDao.counticontype();
        System.out.println("icontype table�� count �� : "+count);
        
        List<IcontypeCommand> listicontype=null; //���ڵ� ���� ��ü ����
        
        if(count > 0) {
            listicontype=icontypeDao.listicontype(); //4���� Ű���� ����
        }else {
            listicontype=Collections.EMPTY_LIST;//������� ���� (�ƹ��͵� ����)
        }
    
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("icontype/05_admin_icon_se.move");
        mav.addObject("count", count);
        mav.addObject("listicontype", listicontype);
        
    
        return mav;

	}
}
