package com.apik.person.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class ListpersonController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	PersonDAO personDao;
	
	@RequestMapping("/05_admin_m_se.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ListpersonControoler ȣ���!");
		
		if(log.isDebugEnabled()) { //���� �αװ�ü�� ���� Debug ���¶��
			System.out.println("process() ȣ���");			
		}
		
		

		//�˻��о�, �˻�� Map�� ��ƾ� �ȴ�.

        //�� ���� 
        int count=personDao.countperson();
        System.out.println("person table�� count �� : "+count);
        
        List<PersonCommand> listperson=null; //���ڵ� ���� ��ü ����
        
        if(count > 0) {
            listperson=personDao.listperson(); //4���� Ű���� ����
        }else {
            listperson=Collections.EMPTY_LIST;//������� ���� (�ƹ��͵� ����)
        }
    
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/05_admin_m_se.move");
        mav.addObject("count", count);
        mav.addObject("listperson", listperson);
        
    
        return mav;

	}
}
