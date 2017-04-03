package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelEmpServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id") );
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		PreparedStatement stat = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/patrickdb", "root","1234");
			stat = conn.prepareStatement("delete from t_emp where id=?");
			stat.setInt(1, id);
			stat.executeUpdate();
			
	
			response.sendRedirect("list"); // redirect to "list" page
		} catch(IOException e){
			
		} catch(SQLException e){
			out.println("System is busy, please try again later");
		} catch (ClassNotFoundException e) {
		} finally {
			if (stat != null){
				try {
					stat.close();
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
			if (conn != null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
	}

}
