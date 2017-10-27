package com.apik.cosloc.service;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.cosloc.command.CoslocCommand;
import com.apik.cosloc.dao.CoslocDAO;

@Controller
public class SearchcoslocController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	CoslocDAO coslocDao;

	@RequestMapping("/admin/searchcosloc.do")
	public ModelAndView searchprocess(@RequestParam("keyField") String keyField,
															@RequestParam("keyWord") String keyWord) throws Exception{
		System.out.println("회원 목록 검색 SearchcoslocController 실행!");
		
        CoslocCommand coslocDto = new CoslocCommand();
        coslocDto.setKeyField(keyField);
        coslocDto.setKeyWord(keyWord);
        
		//총 개수 
        int count=coslocDao.countsearchcosloc(coslocDto);
        System.out.println("검색된 cosloc table의 count 수 : "+count);
        
		List<CoslocCommand> listcosloc=null;
						
		if(count > 0) {			
            listcosloc=coslocDao.searchcosloc(coslocDto);
        }else {
            listcosloc=Collections.EMPTY_LIST;//상수값을 설정 (아무것도 없다)
        }
		
		ModelAndView mav = new ModelAndView();
        mav.setViewName("cosloc/05_admin_cosloc_se.move");
        mav.addObject("count", count);
        mav.addObject("listcosloc", listcosloc);
		
		return mav;
	}
}
