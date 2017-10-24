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
		System.out.println("ListpersonControoler 호출됨!");
		
		if(log.isDebugEnabled()) { //현재 로그객체가 현재 Debug 상태라면
			System.out.println("process() 호출됨");			
		}
		
		

		//검색분야, 검색어를 Map에 담아야 된다.

        //총 개수 
        int count=personDao.countperson();
        System.out.println("person table의 count 수 : "+count);
        
        List<PersonCommand> listperson=null; //레코드 담을 객체 선언
        
        if(count > 0) {
            listperson=personDao.listperson(); //4개의 키값이 전달
        }else {
            listperson=Collections.EMPTY_LIST;//상수값을 설정 (아무것도 없다)
        }
    
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/05_admin_m_se.move");
        mav.addObject("count", count);
        mav.addObject("listperson", listperson);
        
    
        return mav;

	}
}
