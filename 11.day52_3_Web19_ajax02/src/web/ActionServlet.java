package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import bean.Stock;

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

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action  = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if(action.equals("/getCity")){
			String name = request.getParameter("name");
			if(name.equals("bj")){
				out.println("hd,haidian;ct,chaoyang");
			}else if(name.equals("hb")){
				out.println("wh,wuhan;hs,huangshi;jz,jinzhou");
			}else {
				out.println("jn,jinan;qd,qindao");
			}
		}else if(action.equals("/quoto")){
			/**
			 * simulate a few stocks info
			 */
			List<Stock> stocks = new ArrayList<Stock>();
			Random r = new Random();
			NumberFormat df = new DecimalFormat("#.##");			
			for(int i = 0; i<8; i++){
				Stock s = new Stock();
				s.setCode("60001" + r.nextInt(10));
				s.setName("shenzhen development" + r.nextInt(10));
				s.setPrice(Double.parseDouble(df.format(r.nextDouble() *100)));
				stocks.add(s);
			}
			JSONArray jsonArr = new JSONArray(stocks.toArray());
			String jsonStr = jsonArr.toString();
			System.out.println(jsonStr);
			out.println(jsonStr);
		}else if(action.equals("/getNumber")){
			Random r = new Random();
			int number = r.nextInt(10000);
			System.out.println("number: "+number);
			out.println(number);
		}else if(action.equals("/check_username")){
			
			// simulate a time-comsuming task here
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// simulate a system exception 
//			if(true){
//				throw new ServletException("A system exception simulation");
//			}
			
			String username = request.getParameter("username");
			
			
			System.out.println("username: "+username);
			if(username.equals("陈先生") || username.equals("tom")){
				out.print("error");
			}else {
				out.print("ok"); // here you must use print here!!!! ok/n  is different from ok
			}
			
		}else if(action.equals("/check_number")){
			String numberFromUser = request.getParameter("number");
			String numberFormSession = (String)request.getSession().getAttribute("number");
			
			if(!numberFromUser.equalsIgnoreCase(numberFormSession)){
				out.println("checkcode is wrong!");
			}else{
				out.println("checkcode is correct!");

			}
		}
		out.close();
		
	}

}
