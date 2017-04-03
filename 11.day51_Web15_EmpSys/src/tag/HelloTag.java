package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport{

	private String info;
	private int qty;
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		System.out.println("setInfo()..."+info);
		this.info = info;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		System.out.println("setQty()..."+qty);
		this.qty = qty;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("HelloTag's doTag()...");
		PageContext ptx = (PageContext) getJspContext();
		// pageContext can help you find all other hidden objects in jsp
		JspWriter out = ptx.getOut();
		for(int i=0; i<this.qty; i++){
    		out.println(this.info+"<br/>");
    	}
	}
	
}
