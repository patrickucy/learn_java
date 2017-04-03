package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		
		// redirect
		response.sendRedirect(request.getContextPath() +"/function01/a1.jsp");
		
		// forward
		request.getRequestDispatcher("/function01/a1.jsp").forward(request, response);
		
	}

}
 