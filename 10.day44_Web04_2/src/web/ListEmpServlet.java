package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ListEmpServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// access database, get all employee info
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ResultSet rst = null;
		try {
			EmployeeDAO dao = new EmployeeDAO();
			
			List<Employee> employees = dao.findAll();
			
			// output table according to table
			out.println("<table border='1' width='60%' cellpadding='0' cellspacing='0'>");
			out.println("<caption> Employee List </caption>");
			out.println("<tr>"
					+ "<td>ID</td> <td>Name</td> <td>Salary</td> <td>Age</td> <td>Edit</td> "
					+ "</tr>");
			for(Employee e : employees){
				int id = e.getId();
				String name = e.getName();
				double salary = e.getSalary();
				int age = e.getAge();
				out.println("<tr> <td>"+id+"</td> "
						+ "<td>"+name+"</td>"
								+ " <td>"+salary+"</td> "
										+ "<td>"+age+"</td> "
												+ "<td> <a href='del?id="+id+"'>Delete</a> &nbsp;"
														+ " <a href='load?id="+id+"'>Alter</a>  </td></tr>");
			}
			
			out.println("</table>");
			out.println("<a href='addEmp.html'>addEmp</a>");

		} catch (Exception e) {
			out.println("System is busy, try again later");
		} 
	}
}
