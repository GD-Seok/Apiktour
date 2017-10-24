package com.apik.course.service;

import java.util.HashMap;
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

@Controller
public class IntroController {

	// 1) Log객체 생성
		//private Logger log=Logger.getLogger(ListController.class);
		private Logger log=Logger.getLogger(this.getClass());
	
		@Autowired // 자동으로 객체를 구해와 불러옴
		private CourseDAO courseDao;	
		
	@RequestMapping("/index.do")
	public String process() {
		return "intro/intro";
	}
	
	
	@RequestMapping(value="/choice.do",method=RequestMethod.GET)
	public String choice(@RequestParam String mode, Model model) {
		
		String type="";
		
		String m = mode; 
		switch(m) { 
		case "rest": type="피로도"; break; 
		case "play": type="에너지"; break; 
		}
		
		// Log객체를 이용하여 처리과정 콘솔에 출력
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===choice() 호출!===");
			log.debug("mode : " + mode); // 내부적인 처리과정
			System.out.println("===choice() end===");
		}
		
		System.out.println("===choice() 호출!===");
		System.out.println("mode : " + mode);
		System.out.println("===choice() end===");
		
		model.addAttribute("mode", mode);
		model.addAttribute("type", type);
		
		return "intro/choice"; 
	}
	
	
	
	/*@RequestMapping("/choicePro.do")
	public String pro() {
		return "intro/playPro";
	}
	*/
	
	
	@RequestMapping("/choicePro.do")
	public ModelAndView process(
			@RequestParam(value="mode", defaultValue="") String mode,
			@RequestParam(value="level", defaultValue="") String level
			) {
		
		String type="";		
		
		String m = mode; 
		switch(m) { 
		case "rest": type="피로도"; break; 
		case "play": type="에너지"; break; 
		}
		
		int lv = Integer.parseInt(level);
		String play=mode;

		// DB 조회 : 매개변수를 받아 해당하는 코스 개수 조회
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));
		
		int count=courseDao.getCourseCount(map);
				
		
		// Log객체를 이용하여 처리과정 콘솔에 출력
		if (log.isDebugEnabled()) { // 현재 로그객체가 디버그모드상태라면
			System.out.println("===choicePro() 호출!===");
			log.debug("mode : " + mode); // 내부적인 처리과정
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);	
			System.out.println("===choicePro() end===");
		}

		System.out.println("===choicePro() 호출!===");		
		System.out.println("play : " + play);
		System.out.println("lv : " + lv); 
		System.out.println("count : " + count);
		System.out.println("===choicePro() end===");
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("intro/playPro"); //intro/playPro.jsp
		mav.addObject("count", count);
		mav.addObject("type", type);
		mav.addObject("mode", mode);
		mav.addObject("level", level);
		mav.addObject("play", play);
		
		return mav;
	}
	
	
}
