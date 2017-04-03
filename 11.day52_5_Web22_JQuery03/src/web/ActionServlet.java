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
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(action.equals("/price")){
			String flight = request.getParameter("flight");
			
			if(flight.equals("CA1898")){
				out.println("first class: $24000 <br/> business: $2200");
			}else {
				out.println("first class: $16000 <br/> business: $1400");
				
			}
		}else if(action.equals("/quoto")){
			if(new Random().nextInt(2) == 1){
				throw new ServletException();
			}
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
		}
		out.close();
	}

}
