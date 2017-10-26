package com.apik.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

@Controller
public class intro_login_suc_Controller {
	
	@Autowired
	private PersonDAO personDao;
	
	@RequestMapping("/login.do")
	public ModelAndView loginprocess(@RequestParam("id") String id,
														@RequestParam("passwd") String passwd) {
		System.out.println("intro_login_Controller 동작");
		System.out.println("id : " + id);
		System.out.println("passwd : " + passwd);
		
		PersonCommand personDto = new PersonCommand();

		
		
		personDto.setId(id);
		System.out.println("db에 저장된 id 값 : "+personDto.getId());
		personDto.setPasswd(passwd);
		
		ModelAndView mav = new ModelAndView();
		
		int result = personDao.login(personDto);
		System.out.println("로그인 시도 중");
		if(result==0) {
			System.out.println("없는 아이디");
			mav.setViewName("intro/intro");
			mav.addObject(result);
		}else if(result==1) {
			System.out.println("로그인성공");
			mav.setViewName("intro/intro.sc");
		    mav.addObject("id",id);
		    mav.addObject(result);
		}
		return mav;
	}
}
