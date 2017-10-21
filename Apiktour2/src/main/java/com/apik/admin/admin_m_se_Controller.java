package com.apik.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admin_m_se_Controller {
	
	@RequestMapping("/05_admin_m_se.do")
	public String process() {
		return "selectmember";
	}

}
