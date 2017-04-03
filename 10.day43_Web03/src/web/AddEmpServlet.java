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

public class AddEmpServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String username = request.getParameter("uname");
		username = new String(username.getBytes("iso-8859-1"),"utf-8"); // this line of code works both for "post" and "get" method
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");

		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();

		Connection conn = null;
		PreparedStatement stat = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/patrickdb", "root","1234");
			stat = conn.prepareStatement(""
					+ "insert into t_emp(name,salary,age)"
					+ "values(?,?,?)");
			stat.setString(1, username);
			stat.setDouble(2, Double.parseDouble(salary));
			stat.setInt(3, Integer.parseInt(age));
			stat.executeUpdate();
			
			
//			out.println("adding sucessfully!");
//			out.println("<a href='list'>List of employees</a>");
			response.sendRedirect("list"); // redirect to "list" page
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			out.println("System is busy, try again later");
			e.printStackTrace();
		} finally{
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
				}
			}
			if (conn !=null){
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		out.close();
	
	}
}
