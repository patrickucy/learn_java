package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String sessionID = session.getId();
		System.out.println(sessionID);
		session.setMaxInactiveInterval(40);
		Integer count = (Integer)session.getAttribute("count");
		if(count == null){
			// first time 
			count = 1;
		}else{
			count += 1;
		}
		session.setAttribute("count", count);

		out.println("<h1>this is the "+count+" times you visit this page <h1/>"); 
		
//		session.invalidate();// if you add this line of code, this servlet will not record any counts any more
		
		out.close();
		
	}	

}
