package com.patrick.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
public class ToLoginController {
	
	@RequestMapping("/toLogin.do")
	public ModelAndView toLogin(){
		return new ModelAndView("login");
	}



}
