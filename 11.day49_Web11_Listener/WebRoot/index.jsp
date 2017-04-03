<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Index</title> 
 </head>
  
  <body>
    Current online users are: <%=application.getAttribute("count") %> <br>
    
    <a href="logout">Logout(destroy session)</a>
  </body>
</html>
