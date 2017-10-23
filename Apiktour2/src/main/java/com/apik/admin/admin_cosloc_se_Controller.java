package com.apik.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class admin_cosloc_se_Controller {

		@RequestMapping("/admin/05_admin_cosloc_se.do")
		public String process() {
			return "cosloc/05_admin_cosloc_se.move";
		}
}
