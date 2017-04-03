package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class AddEmpServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String name = request.getParameter("uname");
		name = new String(name.getBytes("iso-8859-1"),"utf-8"); // this line of code works both for "post" and "get" method
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();

	

		try {
			EmployeeDAO dao = new EmployeeDAO();
			Employee emp = new Employee();
			emp.setAge(Integer.parseInt(age));
			emp.setName(name);
			emp.setSalary(Double.parseDouble(salary));
			dao.add(emp);
			
			response.sendRedirect("list"); // redirect to "list" page
		} catch (Exception e) {
			out.println("System is busy, try again later");
			e.printStackTrace();
		} 
	}
}
