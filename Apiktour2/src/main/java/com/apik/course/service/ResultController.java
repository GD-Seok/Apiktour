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

	// 1) Log��ü ����
		//private Logger log=Logger.getLogger(ListController.class);
		private Logger log=Logger.getLogger(this.getClass());
	
		@Autowired // �ڵ����� ��ü�� ���ؿ� �ҷ���
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
		
		
		// DB ��ȸ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));
		
		int count=courseDao.getCourseCount(map);  //�Ű������� �޾� �ش��ϴ� �ڽ� ���� ��ȸ
		List<CourseCommand> cosList = null;
		
		// paly�� lv�� �ش��ϴ� �ڽ� ����Ʈ 
		if(count > 0) {
			cosList = courseDao.getCourseList(map);
			System.out.println("cosList : "+cosList);
		}else {
			cosList = Collections.EMPTY_LIST;
		}
		// Log��ü�� �̿��Ͽ� ó������ �ֿܼ� ���
		if (log.isDebugEnabled()) { // ���� �αװ�ü�� ����׸����¶��
			System.out.println("===result() ȣ��!===");
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);	
			System.out.println("===result() end===");
		}
		
		System.out.println("===result() ȣ��!===");	
	

			
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
