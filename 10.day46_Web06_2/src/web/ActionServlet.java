package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		// get uri from out request
		String uri = request.getRequestURI();

		
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		
		if(action.equals("/list")){
			
			
			ResultSet rst = null;
			try {
				EmployeeDAO dao = new EmployeeDAO();
				
				List<Employee> employees = dao.findAll();
				
				// output to view layer 
				/**
				 * Servlet is not good at displaying data,thus, we can use "forward" transfer
				 * data to jsp and process.
				 */
				request.setAttribute("employees", employees);
				RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
				
				
				rd.forward(request, response);
				

			} catch (Exception e) {
				e.printStackTrace();

				/**
				 *  Approach 1: forward a exception to a new page to user
				 *  forward approach
				 */
				request.setAttribute("error_message", "System is busy, Please try again later");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			
			} 
		}else if(action.equals("/add")){
			
			
			String name = request.getParameter("name"); // here is different 
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
				/**
				 *  approach 2: let container to handle 
				 *  just cast a e to a ServletException 
				 */
				e.printStackTrace();
				throw new ServletException(e);
			} 
		}else if(action.equals("/del")){
			
			
			int id = Integer.parseInt( request.getParameter("id") );			
			try {
				EmployeeDAO dao = new EmployeeDAO();
				dao.delete(id);
				response.sendRedirect("list.do"); // redirect to "list" page
			}  catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			} 
			
		}else if(action.equals("/load")){
			
			
			int id = Integer.parseInt( request.getParameter("id"));		
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e =  dao.findById(id);
				request.setAttribute("e", e);
				request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
				
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			} 
			
		}else if(action.equals("/update")){
			
			
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
				e2.printStackTrace();
				throw new ServletException(e2);
			}
		}
		
	}
}
