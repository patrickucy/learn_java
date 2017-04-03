package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if(action.equals("/check_username")){
			
			// simulate a time-comsuming task here
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// simulate a system exception 
//			if(true){
//				throw new ServletException("A system exception simulation");
//			}
			
			String username = request.getParameter("username");
			
			
			System.out.println("username: "+username);
			if(username.equals("陈先生") || username.equals("tom")){
				out.println("username has been taken");
			}else {
				out.println("username is ok");
			}
			
		}else if(action.equals("/check_number")){
			String numberFromUser = request.getParameter("number");
			String numberFormSession = (String)request.getSession().getAttribute("number");
			
			if(!numberFromUser.equalsIgnoreCase(numberFormSession)){
				out.println("checkcode is wrong!");
			}else{
				out.println("checkcode is correct!");

			}
		}
		
	}

}
