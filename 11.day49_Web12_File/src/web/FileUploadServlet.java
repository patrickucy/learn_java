package web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		
		
		/**
		 * enctype="multipart/form-data"
		 * once you have the property above in html, this following way of accessing request parameter 
		 * is no longer available. Thus, we need the apache commons to do this job of File uploading 
		 */
		String username = request.getParameter("uname");
		System.out.println("username: "+username);
		
		
		/**
		 * new way!
		 */
		
		
		
		/**
		 * step1, create DiskFileitemFactory object
		 * this object can provide some certain config for our parser
		 */
		DiskFileItemFactory diff = new DiskFileItemFactory();
		
		/**
		 * step2, create parser
		 */
		ServletFileUpload sfu = new ServletFileUpload(diff);
		
		/**
		 * step3, use paser to parse
		 * 
		 * parser will encapsulate data in every field to a FileItem object,
		 * FileItem object gives us methods to gain access to request parameter
		 */
		try {
			List<FileItem> items = sfu.parseRequest(request);
			
			for(FileItem item : items){
				if(item.isFormField()){
					// normal form field
					String paraName = item.getFieldName();
					String paraValue = item.getString();
//					paraValue = new String(paraValue.getBytes("iso-8859-1"),"utf-8"); // solve chinese problem
					
					
					System.out.println("paraName: "+paraName+"   paraValue: "+paraValue);
				}else{
					// upload file field
					// write data from browser to local server
					ServletContext sctx = getServletContext();
					// this is just the path of this folder, you now need to name of that file
					String path = sctx.getRealPath("upload"); 
					System.out.println("path: "+path);
					
					/**
					 *  this method has a bug, sometimes in different os, it will return a 
					 *  full path instead of a filename. 
					 */
					String fileName = item.getName(); // this is getFileName
					// prevent the bug just mentioned
					fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
					
					System.out.println("filename: "+fileName);
					
					File file = new File(path+File.separator+fileName);
					item.write(file);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("upload error!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
