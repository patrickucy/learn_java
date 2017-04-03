package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommentFilter1 implements Filter{
	
	public CommentFilter1() {
		// TODO Auto-generated constructor stub
		System.out.println("filter1's constructor...");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 *  this is the main function for this filter
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter1's doFilter() begins");
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(content.indexOf("dog") != -1){
			out.println("illegal comment");
		}else{
			// call the following filter or servlet
			arg2.doFilter(arg0, arg1);
		}
		
		System.out.println("filter1's doFilter() ends");

	}

	/**
	 * after you start the container, it will create a filter instance immediately 
	 * FilterConfig's purpose is to access the initial parameter of our filter<init-param>
	 * 
	 * will be called only once
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter's init...");
	}

	
}
