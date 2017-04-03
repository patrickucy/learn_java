package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckCodeServlet extends HttpServlet {

	private int width = 100;
	private int height = 30;
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		System.out.println("CheckCodeServlet's serivce()...");
		/**
		 * draw image
		 */
		// step1, create a memory mapping object
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		// step2, need a painter
		Graphics g = image.getGraphics();
		
		// step3, set a color
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		
		// step4, paint, setup background
		g.fillRect(0, 0, width, height);
		
		// step5, set a color for painter and paint
		g.setColor(new Color(0,0,0));
		g.setFont(new Font(null, Font.BOLD, 20));
		String number = getNumber(5); // return a String with 5 characters
		g.drawString(number, 5, 22);

		/**
		 *  bind the number checkcode to session object
		 */
		HttpSession session = request.getSession();
		session.setAttribute("number", number);
		
		
		for(int i=0;i<6;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}
		
		/**
		 * output image
		 */
		response.setContentType("image/png");
		// you need a byte stream here
		OutputStream ops = response.getOutputStream();
		// compress the image
		javax.imageio.ImageIO.write(image, "png", ops);
		ops.close();
	}
	
	/*
	 * return a check code
	 */
	private String getNumber(int size){
		String strs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String str = "";
		Random r = new Random();
		for(int i=0; i<size;i++){
			str += strs.charAt(r.nextInt(strs.length()));
			
		}
		return str;
	}

}
