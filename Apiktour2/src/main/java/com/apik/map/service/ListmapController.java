package com.apik.map.service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apik.map.command.MapCommand;
import com.apik.map.dao.MapDAO;

@Controller
public class ListmapController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	MapDAO mapDao;
	
	@RequestMapping("/admin/05_admin_map_se.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ListmapController ȣ���!");
		
		if(log.isDebugEnabled()) { //���� �αװ�ü�� ���� Debug ���¶��
			System.out.println("process() ȣ���");			
		}	
		

		//�˻��о�, �˻�� Map�� ��ƾ� �ȴ�.

        //�� ���� 
        int count=mapDao.countmap();
        System.out.println("map table�� count �� : "+count);
        
        List<MapCommand> listmap=null; //���ڵ� ���� ��ü ����
        
        if(count > 0) {
        	listmap=mapDao.listmap(); //4���� Ű���� ����
        }else {
        	listmap=Collections.EMPTY_LIST;//������� ���� (�ƹ��͵� ����)
        }
    
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("map/05_admin_map_se.move");
        mav.addObject("count", count);
        mav.addObject("listmap", listmap);
        
    
        return mav;

	}
}
