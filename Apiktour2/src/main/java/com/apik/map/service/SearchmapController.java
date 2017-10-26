package com.apik.map.service;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.map.command.MapCommand;
import com.apik.map.dao.MapDAO;
import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class SearchmapController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	MapDAO mapDao;

	@RequestMapping("/admin/searchmap.do")
	public ModelAndView searchprocess(@RequestParam("keyField") String keyField,
															@RequestParam("keyWord") String keyWord) throws Exception{
		System.out.println("��� �˻� SearchmapController ����!");
		
        MapCommand mapDto = new MapCommand();
        mapDto.setKeyField(keyField);
        mapDto.setKeyWord(keyWord);
        
		//�� ���� 
        int count=mapDto.countsearchmap(mapDto);
        System.out.println("�˻��� person table�� count �� : "+count);
        
		List<MapCommand> listmap=null;
						
		if(count > 0) {			
			listmap=mapDao.searchmap(mapDto);
        }else {
        	listmap=Collections.EMPTY_LIST;//������� ���� (�ƹ��͵� ����)
        }
		
		ModelAndView mav = new ModelAndView();
        mav.setViewName("member/05_admin_map_se.move");
        mav.addObject("count", count);
        mav.addObject("listmap", listmap);
		
		return mav;
	}
}
