package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{

	private int count = 0;
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		/**
		 * this method will be called will a session just created
		 * HttpSessionEvent: event object
		 */
		System.out.println("session created.");
		count+=1;
		ServletContext sctx = arg0.getSession().getServletContext();
		sctx.setAttribute("count", count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session destroyed");	
		count-=1;
		ServletContext sctx = arg0.getSession().getServletContext();
		sctx.setAttribute("count", count);
	}

}
