package com.apik.person.service;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;
import com.apik.person.util.PagingUtil;

@Controller
public class ListpersonController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private PersonDAO personDao;
	
	@RequestMapping("/admin/05_admin_m_se.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage ) {
		
		if(log.isDebugEnabled()) { //현재 로그객체가 현재 Debug 상태라면
			System.out.println("process() 호출됨");
			log.debug("currentPage : "+currentPage); //내부적인 처리과정 확인		
		}

        //총 개수 
        int count=personDao.getRowCount();
        
        //map 추가
        List<PersonCommand> listperson=null; //레코드 담을 객체 선언
        
        if(count > 0) {
            listperson=personDao.listperson(); //4개의 키값이 전달
        }else {
            listperson=Collections.EMPTY_LIST;//상수값을 설정 (아무것도 없다)
        }
        
        PagingUtil page=new PagingUtil(currentPage,count,10,10,"listpseron.do");
        
    
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/05_admin_m_se.move");
        mav.addObject("count", count);
        mav.addObject("listperson", listperson);
        mav.addObject("pagingHtml", page.getPagingHtml()); //링크문자열(이전, 다음)
    
        return mav;

	}
}
