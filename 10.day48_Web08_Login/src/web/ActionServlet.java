package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

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
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));

		if(action.equals("/login")){

			/**
			 * check the checkcode first, between the code from user and session 
			 */
			String numberFromUser = request.getParameter("number");
			String numberFormSession = (String)request.getSession().getAttribute("number");
			
			if(!numberFromUser.equalsIgnoreCase(numberFormSession)){
				request.setAttribute("number_error", "checkcode is wrong");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			
			
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			UserDAO dao = new UserDAO();
			try {
				User user = dao.findByUsername(username);
				if(user !=null && user.getPwd().equals(pwd)){
					// login successfully, bind some data at session object
					HttpSession session = request.getSession();
					session.setAttribute("user", user); // bind a user to session obejct
					
					
					
					
					
					response.sendRedirect("main.jsp");
					
				}else {
					/**
					 *  fail to log in 
					 */
					request.setAttribute("login_error", "accout or password is wrong");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
					
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		
	}

}
