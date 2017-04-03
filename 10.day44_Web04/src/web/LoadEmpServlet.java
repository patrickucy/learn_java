package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;


public class LoadEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt( request.getParameter("id"));
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		try {
			EmployeeDAO dao = new EmployeeDAO();
			Employee e =  dao.findById(id);
			
			if(e!=null){
				String name = e.getName();
				double salary = e.getSalary();
				int age = e.getAge();
				
				out.println("<form action='modify?id="+id+"' method='post'>"
						+ "ID: "+id+"<br/>" 
						+ "Name: <input name='name' value='"+name+"' /> <br/>"
						+ "Salary: <input name='salary' value='"+salary+"' /> <br/>"
						+ "Age: <input name='age' value='"+age+"' /> <br/>"
//						+ "<input type='hidden' name='id' value='"+id+"'/>"
						+ "<input type='submit' value='sumit'/>"
						+ "</form>");
			
			}
		} catch (Exception e) {
			out.println("System is busy, try again later");
			e.printStackTrace();
		} 
		
		
		
	}
}
