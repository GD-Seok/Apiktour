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
		System.out.println("ListicontypeControoler 호출됨!");
		
		if(log.isDebugEnabled()) { //현재 로그객체가 현재 Debug 상태라면
			System.out.println("process() 호출됨");			
		}
		
		

		//검색분야, 검색어를 Map에 담아야 된다.

        //총 개수 
        int count=icontypeDao.counticontype();
        System.out.println("icontype table의 count 수 : "+count);
        
        List<IcontypeCommand> listicontype=null; //레코드 담을 객체 선언
        
        if(count > 0) {
            listicontype=icontypeDao.listicontype(); //4개의 키값이 전달
        }else {
            listicontype=Collections.EMPTY_LIST;//상수값을 설정 (아무것도 없다)
        }
    
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("icontype/05_admin_icon_se.move");
        mav.addObject("count", count);
        mav.addObject("listicontype", listicontype);
        
    
        return mav;

	}
}
