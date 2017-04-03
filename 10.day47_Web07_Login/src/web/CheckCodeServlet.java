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
		g.setFont(new Font(null, Font.ITALIC, 20));
//		g.drawLine(x1, y1, x2, y2);
		String number = r.nextInt(99999)+"";
		g.drawString(number, 10, 22);
		
		
		
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

}
