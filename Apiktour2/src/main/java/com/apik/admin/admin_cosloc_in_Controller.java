package com.apik.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admin_cosloc_in_Controller {
		
		@RequestMapping("/05_admin_cosloc_in.do")
		public String process() {
			return "cosloc/05_admin_cosloc_in.move";
		}

}
