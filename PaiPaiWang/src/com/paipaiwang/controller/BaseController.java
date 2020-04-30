package com.paipaiwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//页面跳转控制
@Controller
@RequestMapping("/page")
public class BaseController {
	
	@RequestMapping("/{file}")
	public String goURL(@PathVariable String file) {
		System.out.println("goURL.folder|file==="+"/"+file);
		return "forward:/WEB-INF/jsps/pages/"+file+".jsp";
	}
	
}
