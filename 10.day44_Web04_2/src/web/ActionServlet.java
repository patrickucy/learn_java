package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ActionServlet's service...");
		// get uri from out request
		String uri = request.getRequestURI();
//		System.out.println(uri);
		
		
//		if(uri.equals("/Web04_2/list.do")){
//			System.out.println("Employee List");
//		}else if(uri.equals("/Web04_2/add.do")){
//			System.out.println("Add Employee");
//		}
		
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(action.equals("/list")){
			System.out.println("Employee List");
		}else if(action.equals("/add")){
			System.out.println("Add Employee");
		}
		
	}
}
