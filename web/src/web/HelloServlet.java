package web;

import java.io.PrintWriter;

/**
 * servlet container will call method service after request
 * thus, you have to follow the format as follow
 * @author patrickyu
 *
 */
public class HelloServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// generate a header for a message ->"content-type", telling the browser the return type of data
		response.setContentType("text/html");
		// have a output stream
		PrintWriter out = response.getWriter();
		out.println("<h1 style'color:red'> Hello world </h1>");
		out.close();
	}
}
