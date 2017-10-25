package com.apik.person.service;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class SearchpersonController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	PersonDAO personDao;

	@RequestMapping("/admin/searchperson.do")
	public ModelAndView searchprocess(@RequestParam("keyField") String keyField,
															@RequestParam("keyWord") String keyWord) throws Exception{
		System.out.println("회원 목록 검색 SearchpersonController 실행!");
		
        PersonCommand personDto = new PersonCommand();
        personDto.setKeyField(keyField);
        personDto.setKeyWord(keyWord);
        
		//총 개수 
        int count=personDao.countsearchperson(personDto);
        System.out.println("검색된 person table의 count 수 : "+count);
        
		List<PersonCommand> listperson=null;
						
		if(count > 0) {			
            listperson=personDao.searchperson(personDto);
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
