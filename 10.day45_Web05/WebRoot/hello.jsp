<%@page import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
	<head>
		<title>My First JSP</title>
	</head>
	<body style="font-size:30px; font-style:italic">
	我是大神<br/>
		current time:<%out.println(new Date()); %> <br/>
		current time2:<%=new Date() %><br/>
		<% 
			for(int i=0;i<100;i++){
			%>
				hello kitty<br/>
			<%
			}
		 %>
	</body>
</html>