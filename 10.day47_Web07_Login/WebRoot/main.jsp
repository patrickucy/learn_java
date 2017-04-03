<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("user");
	if(obj == null){
		response.sendRedirect("login.jsp");
		return; // terminate servlet service() method
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'main.jsp' starting page</title>
  </head>
  
  <body>
    This is my <span style="font-size: 90px; color: red;">MAIN</span>MAIN JSP page. <br>
  </body>
</html>
