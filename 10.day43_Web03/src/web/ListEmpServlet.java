package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListEmpServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// access database, get all employee info
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/patrickdb","root","1234");
			stat = conn.prepareStatement("select * from  t_emp");
			rst = stat.executeQuery();
			
			// output table according to table
			out.println("<table border='1' width='60%' cellpadding='0' cellspacing='0'>");
			out.println("<caption> Employee List </caption>");
			out.println("<tr>"
					+ "<td>ID</td> <td>Name</td> <td>Salary</td> <td>Age</td> <td>Edit</td> "
					+ "</tr>");
			while(rst.next()){
				int id = rst.getInt("id");
				String name = rst.getString("name");
				double salary = rst.getDouble("salary");
				int age = rst.getInt("age");
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
		} finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stat !=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn !=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
