package com.apik.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admin_cos_in_Controller {
		
		@RequestMapping("/admin/05_admin_cos_in.do")
		public String process() {
			return "cos/05_admin_cos_in.move";
		}

	}
