package com.patrick.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.patrick.entity.User;

@Controller
@Scope("prototype")
public class LoginCotroller {

// 用原来的Servlet的方法获得
//	@RequestMapping("/login.do")
//	public ModelAndView login(HttpServletRequest req){
//	    String user = req.getParameter("username");
//	    String pwd = req.getParameter("pwd"); 
//	    if("patrick".equals(user) && "12345".equals(pwd)){
//	    	return new ModelAndView("ok");
//	    }else{
//	    	return new ModelAndView("login");
//	    }
//	    
//	}
	
	
	@RequestMapping("/login.do")
	// user实体对象可以接受请求带来的相同key的请求参数
	// model对象可以向响应JSP传递数据
	public ModelAndView login(User user, Model model){
	    String name = user.getUsername();
	    String pwd = user.getPwd();
	  
	    if("patrick".equals(name) && "12345".equals(pwd)){
	    	model.addAttribute("username",name);
	    	model.addAttribute("pwd",pwd);

	    	return new ModelAndView("ok");
	    }else{
	    	model.addAttribute("error","wrong username or password");
	    	return new ModelAndView("login");
	    }
	    
	}
	
	
	
	
	
}
