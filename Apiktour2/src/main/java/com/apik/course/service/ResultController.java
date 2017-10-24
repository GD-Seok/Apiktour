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
public class ResultController {

	// 1) Log��ü ����
		//private Logger log=Logger.getLogger(ListController.class);
		private Logger log=Logger.getLogger(this.getClass());
	
		@Autowired // �ڵ����� ��ü�� ���ؿ� �ҷ���
		private CourseDAO courseDao;	

	/*
	@RequestMapping("/result.do")
	public String result() {
		return "resultMap";
	}*/
	
	// map ������ �߰�
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
	
	
	
	@RequestMapping("/json.do")
	//@ResponseBody
	public String json(Model model) {
		String play = "rest";
		int lv = 1;
		
		// DB ��ȸ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));

		int count = courseDao.getCourseCount(map); // �Ű������� �޾� �ش��ϴ� �ڽ� ���� ��ȸ
		String jsonMap = null;
		List<CourseVO> cosMakerList = null;
		//CourseVO couservo;
		// paly�� lv�� �ش��ϴ� �ڽ� ����Ʈ
		if (count > 0) {
			cosMakerList = courseDao.getCourseMarkerList(map);
			System.out.println("cosMakerList : " + cosMakerList);
			 StringBuffer buffer = new StringBuffer(); 
			 buffer.append("[");
			 	// {"id":1, "name":"ȫ�浿","age":23}
			 	for(int i=0; i<cosMakerList.size(); i++){
			 		CourseVO c=cosMakerList.get(i);
			 		String mesg = "{"; //������ ���� ���� ����, �����ǥ ǥ����� : " = \"
			 		mesg+="name: "+"\""+c.getLocname()+"\","; // "id":"1" 
			 		mesg+=" location: "+"["+c.getLocationx()+", ";
			 		mesg+=+c.getLocationy()+"]";
			 		mesg+="}";
			 		buffer.append(mesg); // buffer�� �߰��Ŀ� ���ڵ尡 �� �ִ��� �������� Ȯ���� �ؾ���
			 		// ���ڵ尡 1�� �̻��� ���: {"id":1, "name":"ȫ�浿","age":23} , {"id":1, "name":"ȫ�浿","age":23}
			 		// ���ڵ尡 �������� ���� ,�� ���� ����
			 		if(i!=cosMakerList.size()-1) buffer.append(","); // i�� �� ������ �ε��� ��ȣ�� �ƴ϶�� , �߰�
			 	}
			 buffer.append("]");
			 System.out.println(buffer.toString());
			 jsonMap = buffer.toString();
			 System.out.println("jsonMap"+jsonMap);
		} else {
			cosMakerList = Collections.EMPTY_LIST;
		}
				
		// Log��ü�� �̿��Ͽ� ó������ �ֿܼ� ���
		if (log.isDebugEnabled()) { // ���� �αװ�ü�� ����׸����¶��
			System.out.println("===json() ȣ��!===");
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);
			System.out.println("===json() end===");
		}

		System.out.println("===json() ȣ��!===");

		System.out.println("play : " + play);
		System.out.println("lv : " + lv);
		System.out.println("count : " + count);
		// System.out.println("cosCount : " + cosCount);
		System.out.println("===json() end===");

		model.addAttribute("count", count);
		model.addAttribute("play", play);
		model.addAttribute("lv", lv);
		model.addAttribute("jsonMap", jsonMap);
		model.addAttribute("cosMakerList", cosMakerList);

		return "result/json"; // return "�̵��� ��������"; Ȯ���� ����
	}
	
	
/*	@RequestMapping(value="/json.do")
	@ResponseBody
	public Map<String, Object> test(){
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("1", "111");
	    	map.put("2", 222);
	    	return map;
	    }
	
	*/
	
	/*
	@RequestMapping("jsonlist2")
	public Map<String, Object> jjson() {
		
		String play = "rest";
		int lv = 1;
		
		// DB ��ȸ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("play", play);
		map.put("lv", new Integer(lv));

		int count = courseDao.getCourseCount(map); // �Ű������� �޾� �ش��ϴ� �ڽ� ���� ��ȸ
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<CourseVO> cosMakerList = null;
		// paly�� lv�� �ش��ϴ� �ڽ� ����Ʈ
		if (count > 0) {
			cosMakerList = courseDao.getCourseMarkerList(map);
			System.out.println("cosMakerList : " + cosMakerList);
			for(CourseVO courseVo : cosMakerList){
				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("sawon_no", courseVo.getLocname());
				map2.put("sawon_no", courseVo.getLocationx());
				map2.put("sawon_no", courseVo.getLocationy());
				map2.put("sawon_no", courseVo.getLoctype());
				list.add(map2);
			}
		} else {
			cosMakerList = Collections.EMPTY_LIST;
		}
				
		// Log��ü�� �̿��Ͽ� ó������ �ֿܼ� ���
		if (log.isDebugEnabled()) { // ���� �αװ�ü�� ����׸����¶��
			System.out.println("===jjson() ȣ��!===");
			log.debug("play : " + play);
			log.debug("lv : " + lv);
			log.debug("count : " + count);
			System.out.println("===jjson() end===");
		}
		
		Map<String, Object> returnData = new HashMap<String, Object>();
		returnData.put("cosMakerList", list);
		System.out.println("returnData" + returnData);
		//ModelAndView mav = new ModelAndView();		
		//mav.setViewName(returnData); 
		return returnData;
	}
		
		*/
	
}
