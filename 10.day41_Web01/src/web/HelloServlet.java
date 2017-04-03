package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	/**
	 * servlet container will receive request and call the service()
	 * the format have to be the same as below
	 * @throws IOException 
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		// read request parameter
		// "uname" is the name of incoming parameter, if you get it wrong it will return a "null" value
		String username = request.getParameter("uname");
		
		
		// generate a header, just like telling someone that what are you going to do next 
		// browser will know the return type of data
		response.setContentType("text/html");

		// we now need a output stream
		PrintWriter out = response.getWriter();
		
		// output
		out.println("<h1 style='color:red;'> Hello "+ username+  " </h1>");
		out.close();
		
	}
}
