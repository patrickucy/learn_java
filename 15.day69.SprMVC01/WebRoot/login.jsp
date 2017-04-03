<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  ${error }
  <body style="font-size: 20px; font-style: italic;">
    <form action="login.do" method="post">
    	Username:<input type="text" name="username"/> <br>
    	Password:<input type="password" name="pwd"/> <br>
    	<input type="submit" value="Login">
    </form>
  </body>
</html>
