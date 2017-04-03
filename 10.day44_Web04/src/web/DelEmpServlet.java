package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;

public class DelEmpServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id") );
		PrintWriter out = response.getWriter();
		


		try {
			EmployeeDAO dao = new EmployeeDAO();
			dao.delete(id);
	
			response.sendRedirect("list"); // redirect to "list" page
		}  catch(Exception e){
			out.println("System is busy, please try again later");
		} 
		
	}

}
