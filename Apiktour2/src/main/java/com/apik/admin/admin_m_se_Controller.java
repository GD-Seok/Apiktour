package com.apik.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admin_m_se_Controller {
	
	@RequestMapping("/admin/05_admin_m_se.do")
	public String process() {
		return "member/05_admin_m_se.move";
	}

}
