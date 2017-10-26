package com.apik.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apik.course.command.CourseCommand;
import com.apik.course.dao.CourseDAO;

@Controller
public class InsertcourseController {
		
		@Autowired
		CourseDAO courseDao;
	
		//POST��İ�, GET ����� ���, redirect�� �̵���ų��, POST�� ���, ó���� ���� �Ǵ�
		@RequestMapping("/admin/insertcourse.do")
		public String submit(@ModelAttribute("courseDto")CourseCommand courseDto,
																					BindingResult result){
			System.out.println("CourseCommand : "+courseDto);
			try {
				courseDao.insertcourse(courseDto);
				System.out.println("ȸ�� ���� ��ϵ�!");
			}catch(Exception e){e.printStackTrace();}
			return "redirect:05_admin_cos_se.do";
		}
		

}
