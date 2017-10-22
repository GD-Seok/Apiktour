package com.apik.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admin_icon_se_Controller {

		@RequestMapping("/05_admin_icon_se.do")
		public String process() {
			return "icontype/05_admin_icon_se.move";
		}

}
