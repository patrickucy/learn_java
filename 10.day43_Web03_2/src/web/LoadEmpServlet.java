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


public class LoadEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt( request.getParameter("id"));
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/patrickdb","root","1234");
			stat = conn.prepareStatement("select * from t_emp where id=?");
			stat.setInt(1, id);
			rst = stat.executeQuery();
			
			if(rst.next()){
				String name = rst.getString("name");
				double salary = rst.getDouble("salary");
				int age = rst.getInt("age");
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
