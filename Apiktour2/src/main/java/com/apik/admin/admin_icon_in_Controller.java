package com.apik.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admin_icon_in_Controller {

		@RequestMapping("/admin/05_admin_icon_in.do")
		public String process() {
			return "icontype/05_admin_icon_in.move";
		}

}
