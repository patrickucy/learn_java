<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body style="font-size: 30px;">
  	<form action="comment" method="post">
  		type in  your comments:<input name="content"> <br/><br/>
  	<input type="submit" value="Post">
  	</form>
  	
  </body>
</html>
