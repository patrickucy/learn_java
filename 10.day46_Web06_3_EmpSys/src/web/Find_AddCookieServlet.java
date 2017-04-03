package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_AddCookieServlet extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			boolean flag = false;
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				String name = c.getName();
				if(name.equals("userId")){
					out.println(c.getValue());
					flag = true;
				}
				
				
			}
			if(!flag){
				// there are cookies, but we can't find this exact c object
				Cookie c = new Cookie("userId","100010");
				response.addCookie(c);
			}
		}else {
			// there is no any cookies available
			Cookie c = new Cookie("userId","100010");
			response.addCookie(c);
			
		}
		
	}

}
