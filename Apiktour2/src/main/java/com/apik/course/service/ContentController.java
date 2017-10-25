package com.apik.course.service;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apik.course.dao.CourseDAO;
import com.apik.course.command.CourseCommand;
import com.apik.course.command.CourseVO;

@Controller
public class ContentController {

	// 1) Log��ü ����
		//private Logger log=Logger.getLogger(ListController.class);
		private Logger log=Logger.getLogger(this.getClass());
	
		@Autowired // �ڵ����� ��ü�� ���ؿ� �ҷ���
		private CourseDAO courseDao;	

/*	
		@RequestMapping("/content.do")
		public String result() {
			return "result/content";
		}
		
	*/
		@RequestMapping("/content.do")
		public ModelAndView contentPro(
				@RequestParam(value="cosnum", defaultValue="") int cosnum,
				@RequestParam(value="cosname", defaultValue="") String cosname,
				@RequestParam(value="mode", defaultValue="") String mode,
				@RequestParam(value="level", defaultValue="") String level
				) {
			System.out.println("===contentPro() ȣ��!===");	
			
			System.out.println("cosnum : " + cosnum);
			System.out.println("cosname : " + cosname);
			System.out.println("mode : " + mode);
			System.out.println("level : " + level);
			
			System.out.println("--- �̻�, post�� �޾ƿ� �� ---");	
			
			//int lv = Integer.parseInt(level);
			//String play=mode;	
			
			String type="";
			
			String m = mode; 
			switch(m) { 
			case "rest": type="�Ƿε�"; break; 
			case "play": type="������"; break; 
			}
			
			
			List<CourseVO> cosnumList = null;
			int count = courseDao.getCourseNumCount(cosnum);
			
			//System.out.println("lv : " + lv);
			//System.out.println("play : " + play);
			System.out.println("type : " + type);
			System.out.println("count : " + count);
			
			if(count > 0) {
				cosnumList = courseDao.getCourseNumList(cosnum);
				System.out.println("cosnumList : "+cosnumList);
			}else {
				cosnumList = Collections.EMPTY_LIST;
			}
			

			// Log��ü�� �̿��Ͽ� ó������ �ֿܼ� ���
			if (log.isDebugEnabled()) { // ���� �αװ�ü�� ����׸����¶��
				System.out.println("===contentPro() ȣ��!===");
				log.debug("cosnum : " + cosnum);
				log.debug("cosnumList : " + cosnumList);
				System.out.println("===contentPro() end===");
			}
			

			System.out.println("===contentPro() end===");
			
			ModelAndView mav = new ModelAndView();		
			mav.setViewName("result/content");
			mav.addObject("cosnumList", cosnumList);
			mav.addObject("count", count);
			mav.addObject("level", level);
			mav.addObject("cosname", cosname);
			mav.addObject("type", type);			
			return mav;
		}	
		
	
}
