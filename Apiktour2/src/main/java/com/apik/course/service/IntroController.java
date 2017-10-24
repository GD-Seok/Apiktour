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

	// 1) Log��ü ����
		//private Logger log=Logger.getLogger(ListController.class);
		private Logger log=Logger.getLogger(this.getClass());
	
		@Autowired // �ڵ����� ��ü�� ���ؿ� �ҷ���
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
		case "rest": type="�Ƿε�"; break; 
		case "play": type="������"; break; 
		}
		
		// Log��ü�� �̿��Ͽ� ó������ �ֿܼ� ���
		if (log.isDebugEnabled()) { // ���� �αװ�ü�� ����׸����¶��
			System.out.println("===choice() ȣ��!===");
			log.debug("mode : " + mode); // �������� ó������
			System.out.println("===choice() end===");
		}
		
		System.out.println("===choice() ȣ��!===");
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
		case "rest": type="�Ƿε�"; break; 
		case "play": type="������"; break; 
		}
		
		int lv = Integer.parseInt(level);
		String play=mode;

		// DB ��ȸ : �Ű������� �޾� �ش��ϴ� �ڽ� ���� ��ȸ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));
		
		int count=courseDao.getCourseCount(map);
				
		
		// Log��ü�� �̿��Ͽ� ó������ �ֿܼ� ���
		if (log.isDebugEnabled()) { // ���� �αװ�ü�� ����׸����¶��
			System.out.println("===choicePro() ȣ��!===");
			log.debug("mode : " + mode); // �������� ó������
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);	
			System.out.println("===choicePro() end===");
		}

		System.out.println("===choicePro() ȣ��!===");		
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
