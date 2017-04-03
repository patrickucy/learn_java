package com.patrick.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
public class HelloController {

	@RequestMapping("/hello.do")
	public ModelAndView execute(){
		
		return new ModelAndView("hello"); // 返回一个ModelAndView对象或者JSP名称
	}
}
