package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {
	public SomeServlet(){
		System.out.println("SomeServlet's constructor...");
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init() is called ");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("SomeServlet's service()...");
//		ServletConfig config = getServletConfig();
		/**
		 * getInitParameter method to access init parameters
		 */
//		String company = config.getInitParameter("company");
//		System.out.println(company);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("SomeServlet's destroy() ...");
	}
}
