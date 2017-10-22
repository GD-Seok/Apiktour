package com.apik.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class admin_map_se_Controller {
		@RequestMapping("/05_admin_map_se.do")
		public String process() {
			return "map/05_admin_map_se.move";
		}


}
