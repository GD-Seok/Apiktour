package com.apik.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class admin_map_in_Controller {
	
		@RequestMapping("/admin/05_admin_map_in.do")
		public String process() {
			return "map/05_admin_map_in.move";
		}

}
