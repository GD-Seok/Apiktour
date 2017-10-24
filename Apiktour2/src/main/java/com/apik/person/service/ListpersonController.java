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
	
	@RequestMapping("/05_admin_m_se.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage,
            @RequestParam(value="keyField",defaultValue="") String keyField,
            @RequestParam(value="keyWord",defaultValue="") String keyWord) {
		
		if(log.isDebugEnabled()) { //현재 로그객체가 현재 Debug 상태라면
			System.out.println("process() 호출됨");
			log.debug("currentPage : "+currentPage); //내부적인 처리과정 확인
			log.debug("keyField : "+keyField);
			log.debug("keyWord : "+keyWord);			
		}

		//검색분야, 검색어를 Map에 담아야 된다.
        Map<String,Object>map = new HashMap<String,Object>();
        map.put("keyField", keyField); //map.get("keyField")로 값을 가져올 수 있다.
        map.put("keyWord", keyWord);
        //총 개수 
        int count=personDao.getRowCount(map);
        //페이징처리 (1.현재페이지 2.개수 3.페이지별로 레코드개수 4.블럭당 보여주는 페이지 개수 5.요청url)
        PagingUtil page=new PagingUtil(currentPage,count,10,10,"listperson.do");
        //list.do로 요청이 들어왔을시, 위와 같이 설정한다. 그 정보를 page에 담는다
        
        //map 추가
        map.put("start", page.getStartCount()); //#{start}
        map.put("end", page.getEndCount()); //#{end}
        List<PersonCommand> listperson=null; //레코드 담을 객체 선언
        
        if(count > 0) {
            listperson=personDao.listperson(map); //4개의 키값이 전달
        }else {
            listperson=Collections.EMPTY_LIST;//상수값을 설정 (아무것도 없다)
        }
    
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/05_admin_m_se.move");
        mav.addObject("count", count);
        mav.addObject("listperson", listperson);
        mav.addObject("pagingHtml", page.getPagingHtml()); //링크문자열(이전, 다음)
    
        return mav;

	}
}
