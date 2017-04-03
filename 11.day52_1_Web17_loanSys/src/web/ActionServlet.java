package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountLimitException;
import service.AccountNotExistException;
import service.AccountService;

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

		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		
		if(action.equals("/to_apply")){
			request.getRequestDispatcher("/WEB-INF/jsp/apply_form.jsp").forward(request, response);
			
		}
		if(action.equals("/apply")){
			String accountNo = request.getParameter("accountNo");
			String amount = request.getParameter("amount");
			// double check illegal input,ignore here
			AccountService service = new AccountService();
			try {
				String number = service.apply(accountNo, Double.parseDouble(amount));
				/**
				 * return the result and tell the view to show data
				 */
				request.setAttribute("number", number);
				request.getRequestDispatcher("/WEB-INF/jsp/view2.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if(e instanceof AccountNotExistException){
					request.setAttribute("apply_error", "account doesn't exist");
					request.getRequestDispatcher("/WEB-INF/jsp/apply_form.jsp").forward(request, response);
					
				}else if(e instanceof AccountLimitException){
					request.setAttribute("apply_error", "low balance");
					request.getRequestDispatcher("/WEB-INF/jsp/apply_form.jsp").forward(request, response);

				}else{
					throw new ServletException(e);
				}
			}
			
			
		}
	}

}
