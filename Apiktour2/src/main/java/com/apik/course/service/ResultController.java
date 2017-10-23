package com.apik.course.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.course.dao.CourseDAO;
import com.apik.course.command.CourseCommand;

@Controller
public class ResultController {

	// 1) Log객체 생성
		//private Logger log=Logger.getLogger(ListController.class);
		private Logger log=Logger.getLogger(this.getClass());
	
		@Autowired // 자동으로 객체를 구해와 불러옴
		private CourseDAO courseDao;	

	
/*	@RequestMapping("/result.do")
	public String result() {
		return "resultMap";
	}
	*/
	
	@RequestMapping("/result.do")
	public ModelAndView result(
			@RequestParam(value="mode", defaultValue="") String mode,
			@RequestParam(value="level", defaultValue="") String level
			//@RequestParam(value="count", defaultValue="") int count
			) {
		
		int lv = Integer.parseInt(level);
		String play=mode;
		
		
		// DB 조회
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));
		
		int count=courseDao.getCourseCount(map);  //매개변수를 받아 해당하는 코스 개수 조회
		List<CourseCommand> cosList = null;
		
		// paly와 lv에 해당하는 코스 리스트 
		if(count > 0) {
			cosList = courseDao.getCourseList(map);
			System.out.println("cosList : "+cosList);
		}else {
			cosList = Collections.EMPTY_LIST;
		}
		// Log객체를 이용하여 처리과정 콘솔에 출력
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===result() 호출!===");
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);	
			System.out.println("===result() end===");
		}
		
		System.out.println("===result() 호출!===");	
	

			
		System.out.println("play : " + play);
		System.out.println("lv : " + lv); 
		System.out.println("count : " + count);
		//System.out.println("cosCount : " + cosCount);
		System.out.println("===result() end===");
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("resultMap"); 
		mav.addObject("count", count);
		mav.addObject("cosList", cosList);
		mav.addObject("play", play);
		mav.addObject("lv", lv);
		//mav.addObject("cosMakerList", cosMakerList);
		
		//mav.addObject("cosCount", cosCount);
		//mav.addObject("cosnumList", cosnumList);
		
		return mav;
	}
	
	
	
	
}
