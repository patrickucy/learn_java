<%@page import="bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'e1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	User user = new User();
    	user.setName("tom");
    	user.setAge(22);
    	request.setAttribute("user", user);
    	
    	
    	User user2 = new User();
    	user2.setName("jetty");
    	user2.setAge(25);
    	session.setAttribute("user", user2);
    	
     %>
     Name:	<%
     			 User user1 = (User)request.getAttribute("user");
     			 out.println(user1.getName());
     		%>
     <br/>		
     Name: ${user.name}
     <br/>
     Name: ${sessionScope.user.name}
     
  </body>
</html>
