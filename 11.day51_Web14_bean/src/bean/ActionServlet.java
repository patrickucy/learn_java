package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(action.equals("/list")){
			Employee1 e = new Employee1();
	    	e.setId(1);
	    	e.setName("tom");
	    	e.setSalary(20000);
	    	e.setAge(23);
	    	request.setAttribute("e", e);
	    	request.getRequestDispatcher("e5.jsp").forward(request, response);
		}else if(action.equals("/list2")){
			List<Employee1> employees = new ArrayList<Employee1>();
	    	for(int i=0;i<8;i++){
	    		Employee1 e = new Employee1();
	    		e.setName("emp00"+(0+i));
	    		e.setAge(22+i);
	    		employees.add(e);
	    	}
	    	request.setAttribute("employees", employees);
	    	request.getRequestDispatcher("jstl03.jsp").forward(request, response);
		}else if(action.equals("/empList")){
			try {
				EmployeeDAO dao = new EmployeeDAO();
				
				List<Employee> employees = dao.findAll();

				request.setAttribute("employees", employees);
				request.getRequestDispatcher("empList.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();

				request.setAttribute("error_message", "System is busy, Please try again later");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			
			} 
		}
		
		
    	
	}

}
