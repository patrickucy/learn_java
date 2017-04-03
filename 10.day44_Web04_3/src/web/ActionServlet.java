package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ActionServlet's service...");
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();

		// get uri from out request
		String uri = request.getRequestURI();

		
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		
		if(action.equals("/list")){
			
			
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
													+ "<td> <a href='del.do?id="+id+"'>Delete</a> &nbsp;"
															+ " <a href='load.do?id="+id+"'>Alter</a>  </td></tr>");
				}
				
				out.println("</table>");
				out.println("<a href='addEmp.html'>addEmp</a>");

			} catch (Exception e) {
				out.println("System is busy, try again later");
			} 
		}else if(action.equals("/add")){
			
			
			String name = request.getParameter("uname");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");

			
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee emp = new Employee();
				emp.setAge(Integer.parseInt(age));
				emp.setName(name);
				emp.setSalary(Double.parseDouble(salary));
				dao.add(emp);
				
				response.sendRedirect("list.do"); // redirect to "list" page
			} catch (Exception e) {
				out.println("System is busy, try again later");
				e.printStackTrace();
			} 
		}else if(action.equals("/del")){
			
			
			int id = Integer.parseInt( request.getParameter("id") );			
			try {
				EmployeeDAO dao = new EmployeeDAO();
				dao.delete(id);
				response.sendRedirect("list.do"); // redirect to "list" page
			}  catch(Exception e){
				out.println("System is busy, please try again later");
			} 
			
		}else if(action.equals("/load")){
			
			
			int id = Integer.parseInt( request.getParameter("id"));		
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e =  dao.findById(id);
				
				if(e!=null){
					String name = e.getName();
					double salary = e.getSalary();
					int age = e.getAge();
					
					out.println("<form action='modify.do?id="+id+"' method='post'>"
							+ "ID: "+id+"<br/>" 
							+ "Name: <input name='name' value='"+name+"' /> <br/>"
							+ "Salary: <input name='salary' value='"+salary+"' /> <br/>"
							+ "Age: <input name='age' value='"+age+"' /> <br/>"
//							+ "<input type='hidden' name='id' value='"+id+"'/>"
							+ "<input type='submit' value='submit'/>"
							+ "</form>");
				
				}
			} catch (Exception e) {
				out.println("System is busy, try again later");
				e.printStackTrace();
			} 
			
		}else if(action.equals("/modify")){
			
			
			int id = Integer.parseInt( request.getParameter("id"));
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
					
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				e.setName(name);
				e.setSalary(salary);
				e.setAge(age);
				e.setId(id);
				dao.modify(e);
				response.sendRedirect("list.do");
				
			
			} catch (Exception e2) {
				out.println("System is busy, try again later");
				e2.printStackTrace();
			}
		}
		
	}
}
