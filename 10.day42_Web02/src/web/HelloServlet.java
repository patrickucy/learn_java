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




public class HelloServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// this line of code must come first
//		request.setCharacterEncoding("utf-8"); // this line of code is only available when using "post" method
		
		String username = request.getParameter("uname");
		username = new String(username.getBytes("iso-8859-1"),"utf-8"); // this line of code works both for "post" and "get" method
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		/**
		 * 1. specify the charset it will be using
		 * 2. declare a header "content-type" and tell the browser.
		 */
//		response.setCharacterEncoding("utf-8"); (recommended!!!!)
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();
//		out.println("员工信息: "+ username +","+age+" years old,"+"with "+salary+" dollars");
		// this line of code will be wrapped as an package into a response object(cache)
		
		/**
		 *  insert new coming data to database 
		 *  import a binary file according the name you given
		 */
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
			out.println("adding sucessfully!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// later you will use a log tool to record all this exception as a file
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
